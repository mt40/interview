package leetcode

import common.SolutionSuite

class PerfectSquaresSuite extends SolutionSuite {
  private def testCase(n: Int, expect: Int) = {
    test(s"Least perfect squares sum to $n") {
      PerfectSquares.numSquares(n) shouldEqual expect
    }
  }

  testCase(1, 1)
  testCase(0, 0)
  testCase(2, 2)
  testCase(4, 1)
  testCase(6, 3)
  testCase(10, 2)
  testCase(17, 2)
}
