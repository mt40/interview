package leetcode

import common.SolutionSuite

class ThreeSumSuite extends SolutionSuite {
  private def testCase(nums: Array[Int], expect: List[List[Int]]) = {
    test(nums.mkString(", ")) {
      val sorted = expect.map(_.sorted)
      ThreeSum.threeSum(nums) shouldEqual sorted
    }
  }

  testCase(
    Array(-1, 0, 1, 2, -1, -4),
    expect = List(List(-1, 0, 1), List(-1, 2, -1))
  )

  testCase(Array(0, 0, 4), expect = List.empty)

  testCase(
    Array(0, 0, 0),
    expect = List(List(0, 0, 0))
  )

  testCase(
    Array(-10, -2, 0, -1, 5, 3, -3),
    expect = List(
      List(-2, -1, 3),
      List(-2, 5, -3),
      List(0, 3, -3)
    )
  )

}
