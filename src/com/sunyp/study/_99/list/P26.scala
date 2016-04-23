package com.sunyp.study._99.list

/**
  * Created by sunyp on 16/4/23.
  *
  * Generate the combinations of K distinct objects chosen from the N elements of a list.
  * In how many ways can a committee of 3 be chosen from a group of 12 people? We all know that there are C(12,3) = 220
  * possibilities (C(N,K) denotes the well-known binomial coefficient). For pure mathematicians, this result may be great.
  * But we want to really generate all the possibilities.
  * Example:
  *
  * scala> combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
  * res0: List[List[Symbol]] = List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), ...
  */
object P26 extends App {

  val lst = List('a, 'b, 'c, 'd, 'e, 'f)

  val K = 3

  // flatMapSublists is like list.flatMap, but instead of passing each element
  // to the function, it passes successive sublists of L.
  def flatMapSubLists[A, B](ls: List[A])(f: (List[A]) => List[B]): List[B] =
    ls match {
      case Nil => Nil
      case sublist => f(sublist) ::: flatMapSubLists(sublist.tail)(f)
    }

  def combinations[A](n: Int, ls: List[A]): List[List[A]] =
    if (n == 0) List(Nil)
    else flatMapSubLists(ls) { sl =>
      combinations(n - 1, sl.tail) map {
        sl.head :: _
      }
    }

  println(s"combinations($K, $lst)=${combinations(K, lst)}")
}
