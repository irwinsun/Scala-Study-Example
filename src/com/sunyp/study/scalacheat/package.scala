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


  def mapmake[T](g: T => T, i: T, seq: List[T]) = seq.map(g)

  val curried = (mapmake[Int] _).curried
  val func = curried({
    _ * 2
  })(3)
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

package object scalacheat_varArgs extends App {
  println("=========scalacheat_varArgs============")

  def sum(args: Int*) = args.sum

  println(sum(1, 2, 3, 4, 5))

}


package object scalacheat_DataStrut extends App {
  println("=========scalacheat_DataStrut 数据结构============")

  (1 to 2).foreach {
    x => print(x + ",")
  }
  println((1 to 2).map({ x => x * 2 }))

  println(s"\nce=${1 to 5 by 2}")

  1 until 6 foreach { (x) => print(x + " ") }
  //  1 until 6 foreach println

  var (x, y, z) = (1, 2, 3)
  println(x + ":" + y + ":" + z)
  // 元素 + 列表  = 新列表
  println(1 :: List(2, 3))

}

package object scalacheat_Control {
  println("=========scalacheat_Control 控制结构============")

  val xs = List(1, 2, 3, 4, 5)

  import scala.util.control.Breaks._

  breakable {
    //防止break的异常BreakControl
    for (x <- xs) {
      if (Math.random < 0.81) {
        println("break")
        break //break是一个方法, 不是语法
      }
    }
  }
}

package

object classDefine {

  class privateVar(private var var用了private_var修饰后这个是私有变量成员: String)

  class publicVar(var 只用var修饰后这个是公有变量成员: String)

  class privateValDefault(没有private_val修饰符后这个是私有常量成员: String) {
    private val 这个成员与构造方法中的一样_无法被外部所识别到_只能在内部使用 = 没有private_val修饰符后这个是私有常量成员
  }

  class privateVal(private val 修饰符后这个是私有常量成员: String)

  class publicVal(val 只用val修饰后这个是公有常量成员: String)

}

package

object scalacheat_class extends App {
  println("=========scalacheat_class类定义及使用===========")

  //引入所有类,除了privateVal和privateVar类不被引入
  import com.sunyp.study.classDefine.{privateVal => _, privateVar => _}


  println(new publicVar("可以直接引用公有变量成员").只用var修饰后这个是公有变量成员)
  println(new publicVal("可以直接引用公有常量成员").只用val修饰后这个是公有常量成员)

  //   new privateVar("会报错,无法直接引用私有成员").var用了private_var修饰后这个是私有变量成员
  //  new privateValDefault("会报错,无法被.号识别出成员").没有private_val修饰符后这个是私有常量成员
  //  new privateValDefault("会报错,无法被.号识别出成员").这个成员与构造方法中的一样_无法被外部所识别到_只能在内部使用
  //  new privateVal("会报错,无法直接引用私有成员").修饰符后这个是私有常量成员


  class C(var x: Int) {
    assert(x > 0, "positive please")
    var y = x
    val readonly = 5
    private var secret = 1

    //    def this = this(42)
  }

  val c = new C(1)
  c.x = 3
  c.y = 4
}

package

object scalacheat_object extends App {
  println("=========scalacheat_object对象============")

  trait Logger {
    def log(message: String) {
      println(s"日志Trait帮你打印 message=$message")
    }
  }

  abstract class UndoableAction(val description: String) {
    def undo(): String

    def redo(): Unit
  }

  //伴生对象 companion object
  object UndoableAction {

    def apply(d: String) = new UndoableAction(d) {
      override def redo(): Unit = {}

      override def undo(): String = s"伴生对象的生成类对象:$description"
    }
  }

  println(UndoableAction("hello") undo())

  // 继承自抽象类的例子
  object DoNothingAction extends UndoableAction("Do nothing") {
    override def undo() = description

    override def redo() {}
  }

  val action = Map("open" -> DoNothingAction, "save" -> DoNothingAction)

  println(action.get("open").get undo())

  // 乱入 特质
  class Joke(var a: String)

  val nothing = new Joke("jacky")
  val logNothing = new Joke("jacky") with Logger

  logNothing.log(logNothing.a)
}