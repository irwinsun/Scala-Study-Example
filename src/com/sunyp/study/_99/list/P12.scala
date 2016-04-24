package com.sunyp.study._99.list

import com.sunyp.study.utils.ListUtils

/**
  * Created by sunyp on 16/4/22.
  *
  * Decode a run-length encoded list.
  * Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
  * Example:
  *
  * scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
  * res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  *
  */
object P12 extends App {

  val lst = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
  val types = (1, 'a)

  def decode[A](ls: List[(Int, A)]): List[A] = ls flatMap { e => List.fill(e._1)(e._2) }

  println(s"decode($lst)=${ListUtils.decode(lst, { d: (Int, Symbol) => List.fill(d._1)(d._2) })}")

  val b = List('a,'b,'c,'d)
  //没变化
  println(ListUtils.decode(b, {x:Symbol=>List(x)}))
}
