package misc

import common.SolutionSuite

class LCMSuite extends SolutionSuite {
  private def testCase(a: Int, b: Int, expect: Int) = {
    test(s"LCM of $a & $b") {
      LCM(a, b) shouldEqual expect
    }
  }

  testCase(a = 30, b = 42, expect = 210)
  testCase(a = 42, b = 30, expect = 210)
  testCase(a = 40, b = 40, expect = 40)
  testCase(a = 5, b = 7, expect = 35)
}
