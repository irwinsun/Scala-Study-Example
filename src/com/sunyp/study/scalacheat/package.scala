package com.sunyp.study

/**
  * curry的两种写法,第2种需要立即提供所有参数
  * Created by sunyp on 16/4/18.
  */
package object scalacheat_FuncCurry extends App {

  println("=========scalacheat_FuncCurry============")
  val gg = { (x: Int) => x * 2 }
  val hh = { (x: Int) => x - 1 }
  val score = (mean: R, sd: R) => (x: R) => (x - mean) / sd
  var curryFunc1 = compose1(gg, hh)
  // 函数对象
  // 必须马上提供所有参数,否则会报错; 得出运算结果
  var resultInt = compose2(gg, hh)(2) //Int值

  def compose1[R](g: R => R, h: R => R) = (x: R) => g(h(x))

  def compose2[R](g: R => R, h: R => R)(x: R): R = g(h(x))

  def g(x: Int) = x * 2

  println(s"curryFunc1(2)=${curryFunc1(2)}")
  println(s"resultInt=$resultInt")
  curryFunc1 = compose1(g, h)
  println(s"curryFunc1(2)=${curryFunc1(2)}")
  resultInt = compose2(g, h)(2)
  println(s"resultInt=$resultInt")

  def h(x: Int) = x - 1

  case class R(x: Int) {

    def apply(x: Int): R = new R(x)

    def -(x: R) = R(this.x - x.x)

    def /(x: R) = R(this.x / x.x)
  }

  println(s"score(R(2), R(2))(R(6))=${score(R(2), R(2))(R(6))}")
}

/**
  * 管道的写法
  * Created by sunyp on 16/4/18.
  */
package object scalacheat_Pipeline extends App {
  println("=========scalacheat_Pipeline============")
  println(s"pipeline=${
    (1 to 5) filter {
      _ % 1 == 0
    } map {
      _ * 2
    }
  }")
}