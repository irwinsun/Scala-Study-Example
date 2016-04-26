package com.sunyp.study._99.arithmetic

/**
  * Created by sunyp on 16/4/24.
  *
  * Determine whether a given integer number is prime.
  * scala> 7.isPrime
  * res0: Boolean = true
  */
object P31 extends App {

  val primes = Stream.cons(2, Stream.from(3, 2) filter {
    _.isPrime
  })
  /**
    * 隐式类转换, 让某个类型的元素获得扩展能力
    * @param start 要转换的整数值
    */
  implicit class IntToClass(val start: Int) {

    def isPrime: Boolean = (start > 1) && (primes takeWhile {
      _ <= Math.sqrt(start)
    } forall {
      start % _ != 0
    })
  }

  println(16.isPrime)

  println(7.isPrime)

}
