package com.sunyp.study._99.list

/**
  * Created by sunyp on 16/4/15.
  *
  * Find the number of elements of a list.
  * Example:
  * scala> length(List(1, 1, 2, 3, 5, 8))
  * res0: Int = 6
  */
object P04 extends App {

  val ints: List[Int] = List(1, 1, 2, 3, 5, 8)

  def length[A](l: => List[A]): Int = l.size


  println(s"length(2)=${length(ints)}")

  // Simple recursive solution.
  def lengthRecursive[A](ls: List[A]): Int = ls match {
    case Nil => 0
    case _ :: tail => 1 + lengthRecursive(tail)
  }

  // Tail recursive solution.  Theoretically more efficient; with tail-call
  // elimination in the compiler, this would run in constant space.
  // Unfortunately, the JVM doesn't do tail-call elimination in the general
  // case.  Scala *will* do it if the method is either final or is a local
  // function.  In this case, `lengthR` is a local function, so it should
  // be properly optimized.
  // For more information, see
  // http://blog.richdougherty.com/2009/04/tail-calls-tailrec-and-trampolines.html
  def lengthTailRecursive[A](ls: List[A]): Int = {
    def lengthR(result: Int, curList: List[A]): Int = curList match {
      case Nil => result
      case _ :: tail => lengthR(result + 1, tail)
    }
    lengthR(0, ls)
  }

  // More pure functional solution, with folds.
  def lengthFunctional[A](ls: List[A]): Int = ls.foldLeft(0) { (f, _) => f + 1 }


  println(s"lengthFunctional=${lengthFunctional(ints)}")
}
