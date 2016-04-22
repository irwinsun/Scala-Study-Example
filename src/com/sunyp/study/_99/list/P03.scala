package com.sunyp.study._99.list

/**
  * Created by sunyp on 16/4/15.
  *
  * Find the Kth element of a list.
  * By convention, the first element in the list is element 0.
  * Example:
  * *
  * scala> nth(2, List(1, 1, 2, 3, 5, 8))
  * res0: Int = 2
  */
object P03 extends App {

  def nth[A](n: => Int, l: => List[A]): A =
    if (n >= 0)
      l(n)
    else throw new NoSuchElementException

  val ints: List[Int] = List(1, 1, 2, 3, 5, 8)

  println(s"nth(2)=${nth(2, ints)}")


  // Not that much harder without.
  def nthRecursive[A](n: Int, ls: List[A]): A = (n, ls) match {
    case (0, h :: _) => h
    case (`n`, h :: tail) => nthRecursive(`n` - 1, tail)
    case (_, Nil) => throw new NoSuchElementException
  }

  println(nthRecursive(2, ints))

}
