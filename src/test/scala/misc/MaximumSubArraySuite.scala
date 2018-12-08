package misc

import common.SolutionSuite

class MaximumSubArraySuite extends SolutionSuite {
  private def testCase(nums: Array[Int], expect: Array[Int]) = {
    test(nums.mkString(", ")) {
      MaximumSubArray(nums).sum shouldEqual expect.sum
    }
  }

  testCase(Array(-3, 1, 2), expect = Array(1, 2))
  testCase(Array(-3, -1, -4), expect = Array(-1))
  testCase(Array(1, 2, -3, 1, 1, 2), expect = Array(1, 1, 2))
  testCase(Array(-2, 1, -3, 4, -1, 2, 1, -5, 4), expect = Array(4, -1, 2, 1))
}
