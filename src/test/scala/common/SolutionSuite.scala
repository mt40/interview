package common

import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSuite, Matchers}

abstract class SolutionSuite extends FunSuite with Matchers with GeneratorDrivenPropertyChecks {
  private var testCases: Int = 0

  protected final def makeTest(f: => Unit): Unit = {
    testCases += 1
    test(s"test $testCases")(f)
  }
}
