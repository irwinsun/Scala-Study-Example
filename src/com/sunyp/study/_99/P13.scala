package com.sunyp.study._99

/**
  * Created by sunyp on 16/4/22.
  *
  * Run-length encoding of a list (direct solution).
  * Implement the so-called run-length encoding data compression method directly.
  * I.e. don't use other methods you've written (like P09's pack); do all the work directly.
  * Example:
  *
  * scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  * res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
  */
object P13 extends App {


  val lst = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)


  def encodeDirect[A](ls: List[(A)]): List[(Int, A)] = ls match {
    case h if h == Nil || h.isEmpty => Nil
    case h =>
      val (packed, next) = h.span(_ == h.head)
      (packed.size, packed.head) :: encodeDirect(next)
  }


  println(s"encodeDirect($lst)=${encodeDirect(lst)}")
}
