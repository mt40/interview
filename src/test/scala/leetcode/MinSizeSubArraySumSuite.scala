package leetcode

import common.SolutionSuite

class MinSizeSubArraySumSuite extends SolutionSuite {
  private def testCase(nums: Array[Int], target: Int): Unit = {
    test(s"${nums.mkString(", ")} - $target") {
      val subArrays = nums.inits.flatMap(_.tails).filter(_.nonEmpty)
      val expect = {
        val lengths = subArrays.filter(_.sum >= target).map(_.length)
        if (lengths.nonEmpty) lengths.min else 0
      }
      MinSizeSubArraySum.minSubArrayLen(target, nums) shouldEqual expect
    }
  }

//  testCase(Array(0), 1)
  testCase(Array(1, 2, 3), 5)
  testCase(Array(3, 2, 1), 5)
  testCase(Array(1, 2, 3), 6)
  testCase(Array(1, 2, 1, 6), 6)
  testCase(Array(6), 6)
  testCase(Array(0), 0)
  testCase(Array(1, 5, 0, 3, 2, 3), 7)
  testCase(Array(2, 3, 1, 2, 4, 3), 7)
  testCase(Array(4, 3, 2, 3, 1, 2), 7)
}
