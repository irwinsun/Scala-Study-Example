package com.sunyp.study._99.list

/**
  * Created by sunyp on 16/4/23.
  *
  * Group the elements of a set into disjoint subsets.
  * a) In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons? Write a function
  * that generates all the possibilities.
  * Example:
  * *
  * scala> group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
  * res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David, Evi), List(Flip, Gary, Hugo, Ida)), ...
  * b) Generalize the above predicate in a way that we can specify a list of group sizes and the predicate will return a list of groups.
  * *
  * Example:
  * *
  * scala> group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
  * res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David), List(Evi, Flip, Gary, Hugo, Ida)), ...
  * Note that we do not want permutations of the group members; i.e. ((Aldo, Beat), ...) is the same solution as ((Beat, Aldo), ...).
  * However, we make a difference between ((Aldo, Beat), (Carla, David), ...) and ((Carla, David), (Aldo, Beat), ...).
  * *
  * You may find more about this combinatorial problem in a good book on discrete mathematics under the term "multinomial coefficients".
  */
object P27 extends App {

  import P26._

  val lst = List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")

  val K = 3

  def group3[A](ls: List[A]): List[List[List[A]]] =
    for {
      a <- combinations(2, ls)
      noA = ls diff a
      b <- combinations(3, noA)
    } yield List(a, b, noA diff b)

  def group[A](ns: List[Int], ls: List[A]): List[List[List[A]]] = ns match {
    case Nil => List(Nil)
    case n :: tail => combinations(n, ls) flatMap { c =>
      group(tail, ls diff c) map {
        c :: _
      }
    }
  }

  println(s"group3($lst)=${group3(lst)}")
  println(s"group($lst)=${group(List(2, 3, 4), lst)}")
}