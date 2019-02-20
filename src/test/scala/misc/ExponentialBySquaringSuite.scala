package misc

import common.SolutionSuite

class ExponentialBySquaringSuite extends SolutionSuite {
  private def testCase(b: Double, e: Int) = {
    test(s"Compute $b^$e ($b power $e)") {
      ExponentialBySquaring.recursive(b, e) shouldEqual math.pow(b, e)
      ExponentialBySquaring.iterative(b, e) shouldEqual math.pow(b, e)
    }
  }

  testCase(4, 0)
  testCase(4, 1)
  testCase(4, 2)
  testCase(4, 5)
  testCase(5, 10)
  testCase(2, 10)
  testCase(2, -2)
  testCase(10, -1)
  testCase(3, -3)
  testCase(3, Int.MinValue)
}
