package com.sunyp.study._99.list

/**
  * Created by sunyp on 16/4/22.
  *
  * Rotate a list N places to the left.
  * Examples:
  * scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  * res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
  * *
  * scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  * res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
  */
object P19 extends App {


  val lst = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)

  def rotate[A](rotateCount: Int, ls: List[(A)]): List[A] = {
    if (rotateCount > 0)
      ls.drop(rotateCount) ::: ls.take(rotateCount)
    else
      ls.drop(ls.length + rotateCount) ::: ls.take(ls.length + rotateCount)
  }

  println(s"rotate(3, $lst)=${rotate(3, lst)}")
  println(s"rotate(-2, $lst)=${rotate(-2, lst)}")
}
