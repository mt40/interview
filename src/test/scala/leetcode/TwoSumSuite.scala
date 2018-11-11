package leetcode

import common.SolutionSuite

class TwoSumSuite extends SolutionSuite {
  def testCase(nums: Array[Int], target: Int): Unit = {
    test(s"${nums.toSeq} - $target") {
      val rs = TwoSum.twoSum(nums, target)
      rs(0) should not equal rs(1)
      nums(rs(0)) + nums(rs(1)) shouldEqual target
    }
  }

  testCase(Array(2, 7, 11, 15), 9)
  testCase(Array(5, 1, 0, 3), 4)
  testCase(Array(5, 1, 0, 0), 1)
  testCase(Array(5, 1, 0, 4, 0), 1)
  testCase(Array(5, 1, 0, 0), 0)
  testCase(Array(0, 1, 0), 0)
}
