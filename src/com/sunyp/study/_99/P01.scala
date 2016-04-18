package com.sunyp.study._99

/**
  * Created by sunyp on 16/4/15.
  */
object P01 extends App {

  def last[A](l: => List[A]): A = {
    if (l.isEmpty) throw new NoSuchElementException("")
    l.last
  }

  // The standard functional approach is to recurse down the list until we hit
  // the end.  Scala's pattern matching makes this easy.
  def lastRecursive[A](ls: List[A]): A = ls match {
    case h :: Nil => h
    case _ :: next => lastRecursive(next)
    case _ => throw new NoSuchElementException
  }

  val ints: List[Int] = List(1, 1, 2, 3, 5, 8)
  println(lastRecursive(ints))
  println(s"${last(ints)}")
}
