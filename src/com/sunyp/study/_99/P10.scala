package com.sunyp.study._99

/**
  * Created by sunyp on 16/4/21.
  *
  * Run-length encoding of a list.
  * Use the result of problem P09 to implement the so-called run-length encoding data compression method.
  * Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
  * Example:
  * *
  * scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  * res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
  */
object P10 extends App {


  val lst = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)


  def encode[A](ls: List[A]): List[(Int, A)] = {
    P09.pack(ls).map(x => (x.size, x.head))
  }


  println(s"encode($lst)=${encode(lst)}")
}
