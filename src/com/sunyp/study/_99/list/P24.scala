package com.sunyp.study._99.list

import scala.concurrent.forkjoin.ThreadLocalRandom._

/**
  * Created by sunyp on 16/4/23.
  *
  * Lotto: Draw N different random numbers from the set 1..M.
  * Example:
  * scala> lotto(6, 49)
  * res0: List[Int] = List(23, 1, 17, 33, 21, 37)
  */
object P24 extends App {

  val M = 49
  val cnt = 6


  def lotto(count: Int, M: Int): List[Int] = {
    if (count <= 0) Nil
    else current().nextInt(M) :: lotto(count - 1, M)
  }

  println(s"lotto($cnt,$M)=${lotto(cnt, M)}")
}
