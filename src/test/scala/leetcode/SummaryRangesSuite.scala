package leetcode

import common.SolutionSuite

class SummaryRangesSuite extends SolutionSuite {
  private def testCase(nums: Array[Int], expect: List[String]) = {
    test(s"Summary of: ${nums.mkString(", ")}") {
      SummaryRanges.summaryRanges(nums) should contain theSameElementsAs expect
    }
  }

  testCase(Array.empty, List.empty)
  testCase(Array(1), List("1"))
  testCase(Array(1, 2), List("1->2"))
  testCase(Array(1, 3, 5), List("1", "3", "5"))
  testCase(Array(1, 3, 4, 5, 6, 10, 11, 20), List("1", "3->6", "10->11", "20"))
  testCase(Array(0, 1, 2, 4, 5, 7), List("0->2", "4->5", "7"))
}
