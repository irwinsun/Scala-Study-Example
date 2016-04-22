package com.sunyp.study._99.list

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

/**
  * Created by sunyp on 16/4/23.
  *
  * Create a list containing all integers within a given range.
  * Example:
  * scala> range(4, 9)
  * res0: List[Int] = List(4, 5, 6, 7, 8, 9)
  */
object P22 extends App {


  def range(start: Int, end: Int): List[Int] = List.range(start, end + 1)

  println(s"range(4,9)=${range(4, 9)}")

  def rangeLoop(start: Int, end: Int): List[Int] = {
    val buf = ListBuffer[Int]()
    start to end foreach {
      buf += _
    }
    buf.toList
  }

  println(s"rangeLoop(4,9)=${rangeLoop(4, 9)}")


  def rangeRecursive(start: Int, end: Int): List[Int] = {
    if (end < start) Nil
    else start :: rangeRecursive(start + 1, end)
  }

  def rangeTailRecursive(start: Int, end: Int): List[Int] = {
    @tailrec
    def rangR(e: Int, rec: List[Int]): List[Int] = {
      if (e < start) {
        rec
      }
      else rangR(e - 1, e :: rec)
    }
    rangR(end, Nil)
  }


  println(s"rangeRecursive(4,9)=${rangeRecursive(4, 9)}")
  println(s"rangeTailRecursive(4,9)=${rangeTailRecursive(4, 9)}")
}
