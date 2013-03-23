package mypackage

import io.{Source, BufferedSource}
import ImplicitHelpers._
import Logger._
import scala.math.random
import util.matching.Regex
import util.matching.Regex.Match
import java.util.HashMap
import scala.collection.JavaConversions._
import collection.mutable
import java.net.URLEncoder

case class Guy(name: String, age: Int)

object MainRunner {

  def main(args: Array[String]):Any = {
    callJsonLikeFuncs(
    'onSuccess -> (() => {
      List("clojure", "is", "more", "functional").mkString("-")
    }),
    'onError -> (() => {
      'but_this_is_ok
    })

    )
  }

  def callJsonLikeFuncs(args: (Symbol, () => Any)*) {
    args.foreach { value: (Symbol, () => Any) =>
      value match {
        case (k:Symbol, f:Function0[_]) => {
          println("For k", k)
          println("the value is ", f())
        }
      }
    }
  }


  def caseUnapply {
    val g = new Guy("him", 22)
    val res: Option[(String, Int)] = Guy.unapply(g)
    println(res.head.productIterator.toList)
    // Equals to
    res match {
      case Some((a, b)) => List(a, b); println("the value is", a, b)
      case None =>
    }
  }

  def nativeMapPrinting {
    val y : java.util.Map[String, Int] = new HashMap[String, Int]
    y.put("what?", 1)
    y.put("this is java", 300)
    val x: Map[String, Int] = Map("one" -> 1, "two" -> 42)
    println(x.toString())
    println(y.toString())

    val z: mutable.Map[String, Int] = mapAsScalaMap(y)
    println(z.toString())
  }

  def regexFun {
    //    http://blog.tmorris.net/posts/scalaoption-cheat-sheet/
    val s = "nativecall://login(email,apss,where)"
    val r = new Regex("\\(([^\\)]*)\\)")
    val m: Option[Match] = r.findFirstMatchIn(s)
    m.map { v => println(v.group(1)) }
    m.flatMap { x =>
      println("some again")
      return
    }
    println("never happened")
  }

  def patternMatchingOnArrays {
    val Array(key, value) = "name=alankay".split("=")
    println("the key is %s, the value is %s".format(key, value))
  }

  def simblesAndOSplit {
    println("com.android.Account".split('.').last)
    println('symbol.name)
  }

  def simpleCaseClasse {
    val r = (random * 2).floor.toInt
    val x = r match {
      case 0 => "zero"
      case 1 => "one"
    }
    println(x)
  }


  def passingMultipleFunctions {
    val f = new Functional();
    f.callsTwoFunctions({ () => "returned a string" }, { () => 42 })
  }

  def callLogging {
    log("hey", 'the, "value is", 42)
  }


  def theValueOfThis {
    println(this)
    val f = {
      val x = 5
      "in here i am " + this
    }
    println(f)
  }

  def functional {
    val f = new Functional()
    f.callit {
      val r = 5
      r * 2
    }
    f.callitRunnable {println("a runnable") }
  }


  def outer {
    new Outer("alan").doit
  }

  def format {
    val str = "greetings %s and %s"
    println(str format("Bart", "Homer"))
    this callWithSpaces "hey"
  }


  def callWithSpaces(v: String) = {
    println("with spaces" + v)
  }

  def doio = {
    val source: BufferedSource = Source.fromFile("/Users/daniel/pagerduty/android/compile.sh")
    val lines = source.mkString
    println(lines)
    source.close ()
  }

  def canihaz: String = null

  def basic = {
    var x = new Icase("what?")
    println(x)
    val l = new Inst()
    l.name = "heyheyhey"
    println(l)
    val r = canihaz
    println(r)
  }

}
