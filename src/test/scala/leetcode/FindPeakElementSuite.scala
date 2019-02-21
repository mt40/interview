package leetcode

import common.SolutionSuite

class FindPeakElementSuite extends SolutionSuite {
  private def testCase(nums: Array[Int], expect: Int) = {
    test(s"Find peak of: ${nums.mkString(", ")}") {
      FindPeakElement.findPeakElement(nums) shouldEqual expect
    }
  }

  testCase(Array(0, 1), expect = 1)
  testCase(Array(1, 0), expect = 0)
  testCase(Array(1, 0, 3), expect = 2)
  testCase(Array(0, 1, 3), expect = 2)
  testCase(Array(0, 1, 3, 4), expect = 3)
  testCase(Array(0, 1, 0, 1, 0), expect = 3)
  testCase(Array(0, 1, 0, 1, 2), expect = 4)
  testCase(Array(0, 1, 2, 1, 2), expect = 2)
  testCase(Array(1, 2, 3, 1), expect = 2)
  testCase(Array(1, 2, 1, 3, 5, 6, 4), expect = 5)
}
