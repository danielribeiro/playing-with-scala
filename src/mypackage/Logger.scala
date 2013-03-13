package mypackage

object Logger {
  def log(msgs: Any*) {
    println(getBasicCallerInfo)
    println(msgs.mkString(" "))
  }

  def error(msgs: Any*) {
    println("error " + getBasicCallerInfo)
    println(msgs.mkString(" "))
  }

  private def getBasicCallerInfo = {
    val stack = (new Exception).getStackTrace()(2)
    "%s#%s:%d".format(stack.getClassName, stack.getMethodName, stack.getLineNumber)
  }

}
