package mypackage

import org.scalatest.{FunSpec, FeatureSpec}
import org.scalatest.matchers.ShouldMatchers

class ExampleSpec extends FunSpec with ShouldMatchers {
  it("can add two numbers") {
      (2 + 40) should equal(43)
  }
}