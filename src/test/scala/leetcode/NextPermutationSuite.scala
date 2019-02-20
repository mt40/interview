package leetcode

import common.SolutionSuite

class NextPermutationSuite extends SolutionSuite {
  private def testCase(nums: Array[Int], expect: Array[Int]) = {
    test(s"Next permutation of: ${nums.mkString(", ")}") {
      NextPermutation.nextPermutation(nums)
      nums shouldEqual expect
    }
  }

  testCase(Array.empty, expect = Array.empty)
  testCase(Array(1), expect = Array(1))
  testCase(Array(1, 2), expect = Array(2, 1))
  testCase(Array(2, 1), expect = Array(1, 2))
  testCase(Array(2, 1, 3), expect = Array(2, 3, 1))
  testCase(Array(1, 2, 3, 4), expect = Array(1, 2, 4, 3))
  testCase(Array(1, 2, 4, 3), expect = Array(1, 3, 2, 4))
  testCase(Array(1, 4, 3, 2), expect = Array(2, 1, 3, 4))
  testCase(Array(4, 3, 1, 2), expect = Array(4, 3, 2, 1))
  testCase(Array(2, 3, 1, 3, 3), expect = Array(2, 3, 3, 1, 3))
  testCase(Array(2, 3, 3, 3, 1), expect = Array(3, 1, 2, 3, 3))
  testCase(Array(3, 3, 2, 1), expect = Array(1, 2, 3, 3))
  testCase(Array(1, 5, 1), expect = Array(5, 1, 1))
}
