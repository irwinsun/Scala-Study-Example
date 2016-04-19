package com.sunyp.study._99


/**
  * Created by sunyp on 16/4/15.
  *
  * Flatten a nested list structure.
  * Example:
  * scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
  * res0: List[Any] = List(1, 1, 2, 3, 5, 8)
  */
object P07 extends App {


  val lst = List(List(1, 1), 2, List(3, List(5, 8)))
  val nestedNumbers = List(List(1, 2), List(3, 4))

  println(s"flatten(List(List(1, 1), 2, List(3, List(5, 8))))=${flatten(lst)}")

  def flatten[A](src: => List[Any]): List[A] = src flatMap {
    case ms: List[_] => flatten(ms)
    case as: A => List(as)
  }

}
