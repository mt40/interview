package leetcode

import common.SolutionSuite

class SubarraySumEqualsKSuite extends SolutionSuite {
  private def testCase(nums: Array[Int], k: Int, expect: Int) = {
    test(s"Subarrays with sum $k from ${nums.prettyString}") {
      SubarraySumEqualsK.subarraySum(nums, k) shouldEqual expect
    }
  }

  testCase(Array(0), 0, expect = 1)
  testCase(Array(0), 1, expect = 0)
  testCase(Array(1, -1), 1, expect = 1)
  testCase(Array(1, -1), 0, expect = 1)
  testCase(Array(1, -1, 1), 1, expect = 3)
  testCase(Array(1, -1, 1, 2), 3, expect = 2)
  testCase(Array(1, 2, 1), 3, expect = 2)
  testCase(Array(1, 1, 1), 2, expect = 2)
  testCase(Array(1, 1, 1), 3, expect = 1)
}
