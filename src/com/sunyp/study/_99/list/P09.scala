package com.sunyp.study._99.list

import com.sunyp.study.utils.ListUtils

/**
  * Created by sunyp on 16/4/21.
  *
  * Pack consecutive duplicates of list elements into sublists.
  * If a list contains repeated elements they should be placed in separate sublists.
  * Example:
  * scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  * res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
  */
object P09 extends App {


  val lst = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)


//  def pack[A](ls: List[A]): List[List[A]] = {
//    if (ls == null || ls.isEmpty)
//      List(List())
//    else {
//      val (headLst, next) = ls span {
//        _ == ls.head
//      }
//      if (next == Nil)
//        List(headLst)
//      else
//        headLst :: pack(next)
//    }
//  }

  println(s"pack($lst)=${ListUtils.pack(lst)}")
}
