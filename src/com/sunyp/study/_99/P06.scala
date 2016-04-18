package com.sunyp.study._99

/**
  * Created by sunyp on 16/4/15.
  *
  * Find out whether a list is a palindrome.
  * Example:
  * scala> isPalindrome(List(1, 2, 3, 2, 1))
  * res0: Boolean = true
  *
  */
object P06 extends App {

  val ints: List[Int] = List(1, 2, 3, 2, 1)

  def isPalindrome[A](l: => List[A]): Boolean = l == l.reverse

  println(s"isPalindrome(ints)=${isPalindrome(ints)}")

  println(s"isPalindrome(1::ints)=${isPalindrome(1 :: ints)}")

  // Simple recursive solution.
  def isPalindromeRecursive[A](l: List[A]): Boolean = {
    l.head == l.last && (l.size == 1 || isPalindrome(l.init.tail))
  }

  println(s"isPalindromeRecursive(ints)=${isPalindromeRecursive(ints)}")
  println(s"isPalindromeRecursive(1::ints)=${isPalindromeRecursive(1 :: ints)}")

  /**
    * Flatten a nested list structure.
    * Example:
    * scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
    * res0: List[Any] = List(1, 1, 2, 3, 5, 8)
    */

  def flatten[A](src: => List[A]) : List[A] = {


    src.foldLeft(List[A]())((r,h)=> {
      h match {
        case lst : List[A] => lst ::: r
        case sig : A =>  sig :: r

      }
    })

  }

  println(s"flatten(List(List(1, 1), 2, List(3, List(5, 8))))=${flatten(List(List(1, 1), 2, List(3, List(5, 8))))}")
}
