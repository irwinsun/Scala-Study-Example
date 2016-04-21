package com.sunyp.study._99

import scala.collection.mutable.ListBuffer

/**
  * Created by sunyp on 16/4/21.
  *
  * Eliminate consecutive duplicates of list elements.
  * If a list contains repeated elements they should be replaced with a single copy of the element.
  * The order of the elements should not be changed.
  * Example:
  * scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  * res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
  */
object P08 extends App {


  val lst = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)


  def compress[A](src: => List[A]): List[A] = {


    if (src == null || src.isEmpty)
      List[A]()

    val compressLst = new ListBuffer[A]
    src.foreach(
      x => {
        if (compressLst.isEmpty || compressLst.last != x) {
          compressLst += x
        }
      }
    )

    compressLst.toList
  }

  println(s"compress($lst)=${compress(lst)}")

  def compressRecursive[A](lst: List[A]): List[A] = lst match {
    case Nil => Nil
    case h :: tail => h :: compressRecursive(tail.dropWhile(_ == h))
  }

  println(s"compressRecursive($lst)=${compressRecursive(lst)}")

}
