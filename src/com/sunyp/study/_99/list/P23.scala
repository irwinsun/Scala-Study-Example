package com.sunyp.study._99.list

import com.sunyp.study.utils.ListUtils

/**
  * Created by sunyp on 16/4/23.
  *
  * Extract a given number of randomly selected elements from a list.
  * Example:
  * scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
  * res0: List[Symbol] = List('e, 'd, 'a)
  * Hint: Use the solution to problem P20
  */
object P23 extends App {
  val lst = List('a, 'b, 'c, 'd, 'f, 'g, 'h)

  val cnt = 3


  println(s"randomSelect($cnt,$lst)=${ListUtils.randomSelect(cnt, lst)}")
}
