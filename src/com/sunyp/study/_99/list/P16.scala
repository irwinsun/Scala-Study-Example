package com.sunyp.study._99.list

import scala.collection.mutable.ListBuffer

/**
  * Created by sunyp on 16/4/22.
  *
  * Drop every Nth element from a list.
  * Example:
  * scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  * res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
  */
object P16 extends App {


  val lst = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)

  def dropBad[A](dropStep: Int, ls: List[(A)]): List[A] = {
    if (ls == null || ls.isEmpty)
      return Nil

    if (dropStep <= 0) return ls
    val buf = ListBuffer[A]()
    var step = 0
    ls foreach { x => step += 1; if (step % dropStep != 0) buf += x }

    buf.toList
  }

  def drop[A](dropStep: Int, ls: List[A]): List[A] = ls.zipWithIndex filter { x => (x._2 + 1) % dropStep != 0 } map {
    _._1
  }


  println(s"drop($lst)=${drop(3, lst)}")
}
