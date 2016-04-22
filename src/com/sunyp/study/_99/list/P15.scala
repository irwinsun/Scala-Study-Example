package com.sunyp.study._99.list

/**
  * Created by sunyp on 16/4/22.
  *
  * Duplicate the elements of a list a given number of times.
  * Example:
  * scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
  * res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
  */
object P15 extends App {


  val lst = List('a, 'b, 'c, 'c, 'd)

  def duplicate[A](dup: Int, ls: List[(A)]): List[A] = ls flatMap { x => List.fill(dup)(x) }

  println(s"duplicate($lst)=${duplicate(3, lst)}")
}
