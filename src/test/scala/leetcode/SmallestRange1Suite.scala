package leetcode

import common.SolutionSuite

class SmallestRange1Suite extends SolutionSuite {
  def testCase(nums: Array[Int], k: Int, expect: Int): Unit = {
    test(s"${nums.toSeq} - $k") {
      SmallestRange1.smallestRangeI(nums, k) shouldEqual expect
    }
  }

  testCase(Array(1), k = 0, expect = 0)
  testCase(Array(1), k = 10, expect = 0)
  testCase(Array(0, 10), k = 2, expect = 6)
  testCase(Array(1, 3, 6), k = 3, expect = 0)
  testCase(Array(1, 5), k = 10, expect = 0)
  testCase(Array(1, 4, 9), k = 2, expect = 4)
  testCase(Array(-1, -10, 4, -1), k = 0, expect = 14)
  testCase(Array(-1, -10, 4, -1), k = 100, expect = 0)
  testCase(Array(-1, -10, 4, -1), k = 5, expect = 4)
}
