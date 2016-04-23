package com.sunyp.study._99.list

import scala.concurrent.forkjoin.ThreadLocalRandom

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

  import P20._

  def randomSelect[A](count: Int, ls: List[A]): List[A] = {
    if (count <= 0)
      Nil
    else {
      val (rest, e) = removeAt(ThreadLocalRandom.current().nextInt(ls.length), ls)
      e :: randomSelect(count - 1, rest)
    }
  }

  println(s"randomSelect($cnt,$lst)=${randomSelect(cnt, lst)}")
}
