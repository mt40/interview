package leetcode

import common.SolutionSuite

class SearchInRotatedSortedArraySuite extends SolutionSuite {
  private def testCase(nums: Array[Int], target: Int, expect: Int) = {
    test(s"Search for $target in ${nums.prettyString}") {
      SearchInRotatedSortedArray.search(nums, target) shouldEqual expect
    }
  }

  testCase(Array(1), 1, expect = 0)
  testCase(Array(1), 2, expect = -1)
  testCase(Array(2, 3, 5, 5, 6, 0, 1, 2), 2, expect = 0)
  testCase(Array(2, 3, 5, 5, 6, 0, 1, 2), 6, expect = 4)
  testCase(Array(2, 3, 5, 5, 6, 0, 1, 2), 5, expect = 2)
  testCase(Array(2, 3, 5, 5, 6, 0, 1, 2), 0, expect = 5)
  testCase(Array(4, 5, 6, 7, 0, 1, 2), 0, expect = 4)
  testCase(Array(4, 5, 6, 7, 0, 1, 2), 3, expect = -1)
}
