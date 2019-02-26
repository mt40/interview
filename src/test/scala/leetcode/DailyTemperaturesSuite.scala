package leetcode

import common.SolutionSuite

class DailyTemperaturesSuite extends SolutionSuite {
  private def testCase(temperatures: Array[Int], expect: Array[Int]) = {
    test(s"Temperature forecast of ${temperatures.prettyString}") {
      DailyTemperatures.dailyTemperatures(temperatures) shouldEqual expect
    }
  }

  testCase(Array(0), expect = Array(0))
  testCase(Array(3, 2, 1), expect = Array(0, 0, 0))
  testCase(Array(3, 1, 2, 4, 7), expect = Array(3, 1, 1, 1, 0))
  testCase(Array(9, 4, 7, 10), expect = Array(3, 1, 1, 0))
  testCase(Array(73, 74, 75, 71, 69, 72, 76, 73), expect = Array(1, 1, 4, 2, 1, 1, 0, 0))
}
