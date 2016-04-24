package com.sunyp.study.scalacheat


/**
  * Created by sunyp on 16/4/24.
  */
object CaseClass extends App {

  var ls: Any = new MyEx(1)

  abstract class Expr {
    def echo()
  }

  case class MyEx(a: Int) extends Expr {
    override def echo() = println("MyEx " + this.a)
  }

  case class SayHi(b: Int) extends Expr {
    override def echo() = println("SayHi " + this.b)
  }

  ls = new SayHi(3)
  ls match {
    case SayHi(1) => println("sayHi")
    case MyEx(1) => println("myEx")
    case MyEx(3) => println("BBB")
    case _ => println("unknow")
  }


}
