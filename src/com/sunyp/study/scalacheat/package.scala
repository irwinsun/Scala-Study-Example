package com.sunyp.study

/**
  * curry的两种写法,第2种需要立即提供所有参数
  * Created by sunyp on 16/4/18.
  */
package object scalacheat_FuncCurry extends App {

  println("=========scalacheat_FuncCurry============")

  def compose1[R](g: R => R, h: R => R) = (x: R) => g(h(x))

  def compose2[R](g: R => R, h: R => R)(x: R): R = g(h(x))

  //匿名函数
  val gFunc = { (x: Int) => x * 2 }
  val hFunc = { (x: Int) => x - 1 }

  // curry函数对象
  var curryCompose1 = compose1(gFunc, hFunc)
  println(s"curryCompose1(3)=${curryCompose1(3)}")

  // 必须马上提供所有参数,否则会报错; 得出运算结果
  var resultInt = compose2(gFunc, hFunc)(3) //Int值
  println(s"compose2(gg, hh)(3)=$resultInt")

  // curry 化 compose2 要curry化,就要用 _ 代表部分参数占位 以此来curry化
  var curryCompose2 = compose2(gFunc, hFunc) _
  println(s"curryCompose2(3)=${curryCompose2(3)}")

  case class R(x: Int) {

    def apply(x: Int): R = new R(x)

    def -(x: R) = R(this.x - x.x)

    def /(x: R) = R(this.x / x.x)
  }

  val score = (mean: R, sd: R) => (x: R) => (x - mean) / sd

  println(s"score(R(2), R(2))(R(6))=${score(R(2), R(2))(R(6))}")

  def zscore(mean: R, sd: R) = (x: R) => (x - mean) / sd

  println(s"zscore(R(2), R(2))(R(6))=${zscore(R(2), R(2))(R(6))}")

  def zscore2(mean: R, sd: R)(x: R) = (x - mean) / sd

  val normer = zscore2(R(7), R(4)) _
  println(s"normer(R(2))=${normer(R(2))}")


  def mapmake[T](g: T => T, i:T, seq: List[T]) = seq.map(g)

  var curried = (mapmake[Int] _).curried
  var func = curried({ _ * 2})(3)
  println(s"func=${func(List(1, 2, 3, 4, 5))}")
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