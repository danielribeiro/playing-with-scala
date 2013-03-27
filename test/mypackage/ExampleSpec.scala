package mypackage

import org.scalatest.FeatureSpec
import org.scalatest.matchers.ShouldMatchers

class ExampleSpec extends FeatureSpec with ShouldMatchers {

  feature("The user can pop an element off the top of the stack") {

    scenario("pop is invoked on a non-empty stack") (pending)

    scenario("pop is invoked on an empty stack") (pending)

    scenario("i can add two numbers") {
      (2 + 40) should equal(42)
    }
  }
}