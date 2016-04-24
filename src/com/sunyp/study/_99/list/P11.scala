package com.sunyp.study._99.list

import com.sunyp.study.utils.ListUtils

/**
  * Created by sunyp on 16/4/21.
  *
  * Modified run-length encoding.
  * Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into
  * the result list. Only elements with duplicates are transferred as (N, E) terms.
  * Example:
  *
  * scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  * res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
  */
object P11 extends App {


  val lst = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

  println(s"encode($lst)=${ListUtils.encode(lst, (x: List[Symbol]) => if (x.size == 1) x.head else (x.size, x.head))}")
}
