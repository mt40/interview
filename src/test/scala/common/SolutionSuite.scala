package common

import org.scalatest.{FunSuite, Matchers}

abstract class SolutionSuite extends FunSuite with Matchers {
  private var testCases: Int = 0

  protected final def makeTest(f: => Unit): Unit = {
    testCases += 1
    test(s"test $testCases")(f)
  }
}
