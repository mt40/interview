package misc

import common.SolutionSuite

class SubArraysWithSumInRangeSuite extends SolutionSuite {
  private def testCase(nums: List[Int], range: Range) = {
    test(s"${nums.mkString(",")} - $range") {
      val subArrays = nums.inits.flatMap(_.tails).filter(_.nonEmpty)
      val expect = subArrays.count(arr => range.start <= arr.sum && arr.sum <= range.end)
      SubArraysWithSumInRange(nums, range) shouldEqual expect
    }
  }

  testCase(List(0), 0 to 1)
  testCase(List(1), 0 to 1)
  testCase(List(5), 0 to 1)
  testCase(List(1, 5), 0 to 2)
  testCase(List(1, 5, 0), 0 to 2)
  testCase(List(1, 5), 0 to 10)
  testCase(List(1, 2, 5, -4, 1), 1 to 1)
}
