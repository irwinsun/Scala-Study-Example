package com.sunyp.study._99.list

/**
  * Created by sunyp on 16/4/15.
  *
  * Reverse a list.
  * Example:
  * scala> reverse(List(1, 1, 2, 3, 5, 8))
  * res0: List[Int] = List(8, 5, 3, 2, 1, 1)
  *
  */
object P05 extends App {

  val ints: List[Int] = List(1, 1, 2, 3, 5, 8)

  def reverse[A](l: => List[A]): List[A] = l.reverse


  println(s"reverse(ints)=${reverse(ints)}")

  // Simple recursive solution.
  def reverseRecursive[A](ls: List[A]): List[A] = ls match {
    case Nil => Nil
    case h :: tail => reverseRecursive(tail) ::: List(h)
  }

  println(s"reverseRecursive(ints)=${reverseRecursive(ints)}")

  // Tail recursive solution.  Theoretically more efficient; with tail-call
  // elimination in the compiler, this would run in constant space.
  // Unfortunately, the JVM doesn't do tail-call elimination in the general
  // case.  Scala *will* do it if the method is either final or is a local
  // function.  In this case, `reverseR` is a local function, so it should
  // be properly optimized.
  // For more information, see
  // http://blog.richdougherty.com/2009/04/tail-calls-tailrec-and-trampolines.html
  def reverseTailRecursive[A](ls: List[A]): List[A] = {
    def reverseR(result: List[A], curList: List[A]): List[A] = curList match {
      case Nil => result
      case h :: tail => reverseR(h :: result, tail)
    }
    reverseR(Nil, ls)
  }

  println(s"reverseTailRecursive(ints)=${reverseTailRecursive(ints)}")

  //  println(ints ::: List(3, 2, 1))
  //  println(4 :: ints)

  // More pure functional solution, with folds.
  def reverseFunctional[A](ls: List[A]): List[A] = ls.foldLeft(List[A]()) { (r, h) => h :: r }
  // stupid function
  def reverseFunctional2[A](ls: List[A]): List[A] = ls.foldRight(List[A]()) { (r, h) => h ::: List(r) }
  println(s"reverseFunctional=${reverseFunctional(ints)}")
  println(s"reverseFunctional2=${reverseFunctional2(ints)}")
}
