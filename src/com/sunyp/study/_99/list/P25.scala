package com.sunyp.study._99.list

import com.sunyp.study._99.list.P23.randomSelect

/**
  * Created by sunyp on 16/4/23.
  *
  * Generate a random permutation of the elements of a list.
  * Hint: Use the solution of problem P23.
  * Example:
  *
  * scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
  * res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)
  */
object P25 extends App {

  val lst = List('a, 'b, 'c, 'd, 'e, 'f)

  def randomPermute[A](ls: List[A]): List[A] = randomSelect(ls.length, ls)

  println(s"randomPermute($lst)=${randomPermute(lst)}")
}
