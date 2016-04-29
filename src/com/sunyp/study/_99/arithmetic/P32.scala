package com.sunyp.study._99.arithmetic

import scala.annotation.tailrec

/**
  * Created by sunyp on 16/4/29.
  *
  * Determine the greatest common divisor of two positive integer numbers.
  * Use Euclid's algorithm.
  * scala> gcd(36, 63)
  * res0: Int = 9
  */
object P32 extends App {
  @tailrec
  def gcd(m: Int, n: Int): Int = if (n == 0) m else gcd(n, m % n)

  println(gcd(36, 63))

}
