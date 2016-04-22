package com.sunyp.study._99.list

/**
  * Created by sunyp on 16/4/22.
  *
  * Split a list into two parts.
  * The length of the first part is given. Use a Tuple for your result.
  * Example:
  *
  * scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  * res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  */
object P17 extends App {


  val lst = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)

  def split[A](splitPos: Int, ls: List[(A)]): (List[A], List[A]) = {
    if (ls == null || ls.isEmpty)
      return (Nil, Nil)

    if (splitPos <= 0) return (Nil, ls)
    if (splitPos == ls.length) return (ls, Nil)

    (ls.take(splitPos), ls.drop(splitPos))
  }

  println(s"split($lst)=${split(3, lst)}")
}
