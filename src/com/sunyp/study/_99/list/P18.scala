package com.sunyp.study._99.list

/**
  * Created by sunyp on 16/4/22.
  *
  * Extract a slice from a list.
  * Given two indices, I and K, the slice is the list containing the elements from and including the Ith element up to
  * but not including the Kth element of the original list. Start counting the elements with 0.
  * Example:
  * *
  * scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  * res0: List[Symbol] = List('d, 'e, 'f, 'g)
  */
object P18 extends App {


  val lst = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)

  def slice[A](start: Int, end: Int, ls: List[(A)]): List[A] = ls.slice(start, end)

  println(s"slice(3,7, $lst)=${slice(3, 7, lst)}")
}
