package com.sunyp.study._99.list

import com.sunyp.study.utils.ListUtils

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


  println(s"removeAt(1, $lst)=${ListUtils.removeAt(1, lst)}")
}
