package mypackage

class Functional {
  def callit(func: => Any ) {
    println("the result of func was " + func)
  }

  // See ImplicitHelpers
  def callitRunnable(r: Runnable) {
    r.run()
    println("it ran")
  }

  def callsTwoFunctions(a: () => Any, b: () => Any) {
    println("a results in", a())
    println("b results in", b())
  }


//  Refuses to compile(no varargs on call by name) : http://www.scala-lang.org/node/4272
//  def varargsCallByName(args: (=>Any)*) {
//    args.foreach { v => println("the value is" + v.toString) }
//  }

}
