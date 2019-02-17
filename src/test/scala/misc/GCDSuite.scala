package misc

import common.SolutionSuite

class GCDSuite extends SolutionSuite {
  private def testCase(a: Int, b: Int, expect: Int) = {
    test(s"GCD of $a & $b") {
      GCD(a, b) shouldEqual expect
    }
  }

  testCase(a = 30, b = 42, expect = 6)
  testCase(a = 42, b = 30, expect = 6)
  testCase(a = 40, b = 40, expect = 40)
  testCase(a = 5, b = 7, expect = 1)
}
