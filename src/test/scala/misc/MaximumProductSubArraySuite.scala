package misc

import common.SolutionSuite

class MaximumProductSubArraySuite extends SolutionSuite {
  private def testCase(nums: Array[Int]) = {
    test(nums.mkString(", ")) {
      val subArrays = nums.inits.flatMap(_.tails).filter(_.nonEmpty)
      val expect = subArrays.map(_.product).max
      MaximumProductSubArray(nums) shouldEqual expect
    }
  }

  testCase(Array(1))
  testCase(Array(-1))
  testCase(Array(2, 0, 3))
  testCase(Array(-2, 0, -1))
  testCase(Array(2, 3, -2, 4))
  testCase(Array(-3, -2, -1))
  testCase(Array(-1, -2, -3))
  testCase(Array(2, 3, -1, 10, 0, 1))
  testCase(Array(2, 3, -2, -1))
}
