package leetcode

import common.SolutionSuite

class MaxChunksToMakeSortedSuite extends SolutionSuite {
  private def testCase(arr: Array[Int], expect: Int) = {
    test(s"${arr.toSeq}") {
      MaxChunksToMakeSorted.maxChunksToSorted(arr) shouldEqual expect
    }
  }

  testCase(Array(4, 3, 2, 1, 0), expect = 1)
  testCase(Array(1, 0, 2, 3, 4), expect = 4)
  testCase(Array(0, 1, 2), expect = 3)
  testCase(Array(2, 1, 3, 0, 4), expect = 2)
}
