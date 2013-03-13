package mypackage


object ImplicitHelpers {
  implicit def functionToRunnable[F](f: => F) = new Runnable() { def run() { f } }
}
