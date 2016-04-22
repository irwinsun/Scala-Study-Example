package com.sunyp.study._99.list

/**
  * Created by sunyp on 16/4/15.
  */
object P02 extends App {

  def penultimate[A](l: => List[A]): A = l.init.last

  val ints: List[Int] = List(1, 1, 2, 3, 5, 8)

  println(s"${penultimate(ints)}")

  // But pattern matching also makes it easy.
  def penultimateRecursive[A](ls: List[A]): A = ls match {
    case h :: _ :: Nil => h
    case _ :: tail => penultimateRecursive(tail)
    case _ => throw new NoSuchElementException
  }

  println(penultimateRecursive(ints))

  // Just for fun, let's look at making a generic lastNth function.
  // An obvious modification of the builtin solution works.
  def lastNthBuiltin[A](n: Int, ls: List[A]): A = {
    if (n <= 0) throw new IllegalArgumentException
    if (ls.length < n) throw new NoSuchElementException
    ls.takeRight(n).head
  }

  println(lastNthBuiltin(2, ints))

  println(lastNthRecursive(2, ints))

  // Here's one approach to a non-builtin solution.
  def lastNthRecursive[A](n: Int, ls: List[A]): A = {
    def lastNthR(count: Int, resultList: List[A], curList: List[A]): A =
      curList match {
        case Nil if count > 0 => throw new NoSuchElementException
        case Nil => resultList.head
        case _ :: tail =>
          lastNthR(count - 1,
            if (count > 0) resultList else resultList.tail,
            tail)
      }
    if (n <= 0) throw new IllegalArgumentException
    else lastNthR(n, ls, ls)
  }

  println(s"this is drop 1 is ${ints.drop(1)}")
}
