package com.sunyp.study._99.list

/**
  * Created by sunyp on 16/4/22.
  *
  * Remove the Kth element from a list.
  * Return the list and the removed element in a Tuple. Elements are numbered from 0.
  * Example:
  *
  * scala> removeAt(1, List('a, 'b, 'c, 'd))
  * res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
  */
object P20 extends App {


  val lst = List('a, 'b, 'c, 'd)

  def removeAt[A](removeAt: Int, ls: List[(A)]): (List[A], A) = ls.splitAt(removeAt) match {
    case (Nil, _) if removeAt < 0 => throw new NoSuchElementException
    case (pre, erase :: tail) => (pre ::: tail, erase)
    case (pre, Nil) => throw new NoSuchElementException
  }

  println(s"removeAt(1, $lst)=${removeAt(1, lst)}")
}
