package com.sunyp.study._99.list

/**
  * Created by sunyp on 16/4/23.
  *
  * Insert an element at a given position into a list.
  * Example:
  * scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
  * res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)
  */
object P21 extends App {


  val lst = List('a, 'b, 'c, 'd)

  def insertAt[A](insertObject: A, pos: Int, ls: List[A]): List[A] = ls.splitAt(pos) match {
    case (Nil, _) if pos < 0 => throw new NoSuchElementException
    case (pre, nex) => pre ::: List(insertObject) ::: nex
  }

  println(s"insertAt('new, 1, $lst)=${insertAt('new, 1, lst)}")
}
