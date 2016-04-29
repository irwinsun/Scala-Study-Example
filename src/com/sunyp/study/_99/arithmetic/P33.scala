package com.sunyp.study._99.arithmetic

/**
  * Created by sunyp on 16/4/29.
  *
  * Determine whether two positive integer numbers are coprime.
  * Two numbers are coprime if their greatest common divisor equals 1.
  * scala> 35.isCoprimeTo(64)
  * res0: Boolean = true
  */
object P33 extends App {

  import P32._

  implicit class IntToClass(val start: Int) {
    def isCoprimeTo(n: Int): Boolean = gcd(start, n) == 1
  }

  println(35.isCoprimeTo(63))
  println(35.isCoprimeTo(54))
  println(35.isCoprimeTo(56))
  println(35.isCoprimeTo(64))
  println(35.isCoprimeTo(7))

}
