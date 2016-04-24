package com.sunyp.study.utils


import scala.concurrent.forkjoin.ThreadLocalRandom

/**
  * Created by sunyp on 16/4/24.
  */
object ListUtils {

  /**
    * Pack consecutive duplicates of list elements into sublists.
    * If a list contains repeated elements they should be placed in separate sublists.
    * Example:
    * scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    * res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
    *
    * @param ls ls
    * @tparam A type
    * @return List[List[A
    */
  def pack[A](ls: List[A]): List[List[A]] = {
    if (ls == null || ls.isEmpty)
      List(Nil)
    else {
      val (headLst, next) = ls span {
        _ == ls.head
      }
      if (next == Nil) List(headLst)
      else headLst :: pack(next)
    }
  }

  /**
    * 对一个列表进行编码转换成另一个类型的列表, 具体结果由encFunc函数决定.
    *
    * 举个粟子,统计每个字符出现的次数:
    * scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    * res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
    *
    * 具体结果如何,要根据 encFunc 函数的运算结果决定
    *
    * @param ls ls
    * @tparam A type
    * @param encFunc 编码函数
    * @return List[(Int,A)]
    */
  def encode[A](ls: List[A], encFunc: (List[A]) => (Any)): List[Any] = pack(ls).map(encFunc)

  /**
    * 对一个列表进行转换成另一类型的列表,具体转换由decFunc决定
    * 举个例子:
    * scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
    * res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    *
    * @param ls 列表
    * @tparam A 元素类型
    * @param decFunc 解码函数
    * @return 返回解码后的列表
    */
  def decode[A, B](ls: List[A], decFunc: (A) => (List[B])): List[B] = ls.flatMap(decFunc)

  /**
    * 从指定列表中移除指定位置(下标)的元素,并返回 剩余的和 移除的 二元组
    * scala> removeAt(1, List('a, 'b, 'c, 'd))
    * res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
    *
    * @param removeAt 移除位置下标
    * @param ls       列表
    * @tparam A 类型
    * @return 返回二元组,_1为剩下的元素,_2为移除的元素
    */
  def removeAt[A](removeAt: Int, ls: List[(A)]): (List[A], A) = ls.splitAt(removeAt) match {
    case (Nil, _) if removeAt < 0 => throw new NoSuchElementException
    case (pre, erase :: tail) => (pre ::: tail, erase)
    case (pre, Nil) => throw new NoSuchElementException
  }

  /**
    * 返回从ls列表中随机取出的n个元素
    * scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
    * res0: List[Symbol] = List('e, 'd, 'a)
    *
    * @param count 随机数量
    * @param ls    列表
    * @tparam A 类型
    * @return 随机取出的元素的列表
    */
  def randomSelect[A](count: Int, ls: List[A]): List[A] = {
    if (count <= 0)
      Nil
    else {
      val (rest, e) = removeAt(ThreadLocalRandom.current().nextInt(ls.length), ls)
      e :: randomSelect(count - 1, rest)
    }
  }
}
