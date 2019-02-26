package leetcode

import common.SolutionSuite

class ProductOfArrayExceptSelfSuite extends SolutionSuite {
  private def testCase(nums: Array[Int], expect: Array[Int]) = {
    test(s"Special product array of ${nums.prettyString}") {
      ProductOfArrayExceptSelf.productExceptSelf(nums) shouldEqual expect
    }
  }

  testCase(Array(0, 1), Array(1, 0))
  testCase(Array(1, 2, 3, 4), Array(24, 12, 8, 6))
}
