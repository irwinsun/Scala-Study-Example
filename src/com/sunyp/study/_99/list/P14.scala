package com.sunyp.study._99.list

/**
  * Created by sunyp on 16/4/22.
  *
  * Duplicate the elements of a list.
  * Example:
  * scala> duplicate(List('a, 'b, 'c, 'c, 'd))
  * res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
  */
object P14 extends App {


  val lst = List('a, 'b, 'c, 'c, 'd)

  def duplicate[A](ls: List[(A)]): List[A] = ls flatMap { x => List.fill(2)(x) }

  println(s"duplicate($lst)=${duplicate(lst)}")
}
