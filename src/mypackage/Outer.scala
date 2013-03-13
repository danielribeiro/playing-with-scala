package mypackage

class Outer(val name: String) {
  def sayhi {
    println("outer hi from " + name)
  }

  def doit {
    new Inner().doit
  }

  class Inner {
    def doit {
      delegate.sayhi
    }

    private def delegate = Outer.this

    def sayhi {
      throw new IllegalStateException("You better not be calling me exception")
    }
  }


}
