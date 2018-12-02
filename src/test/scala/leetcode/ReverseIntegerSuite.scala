package leetcode

import common.SolutionSuite

class ReverseIntegerSuite extends SolutionSuite {

  private def testCase(i: Int, expect: Int): Unit = {
    test(i.toString) {
      ReverseInteger.reverse(i) shouldEqual expect
    }
  }

  testCase(12, 21)
  testCase(5, 5)
  testCase(50, 5)
  testCase(150, 51)
  testCase(-123, -321)
  testCase(Int.MinValue, 0)
  testCase(Int.MaxValue, 0)
}
