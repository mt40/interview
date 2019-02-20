package leetcode

import common.SolutionSuite
import MergeIntervals.Interval
import language.implicitConversions

class MergeIntervalsSuite extends SolutionSuite {
  private def testCase(intervals: List[Interval], expect: List[Interval]) = {
    val str = intervals.mkString(", ")
    test(s"Merge: $str") {
      MergeIntervals.merge(intervals) should contain theSameElementsAs expect
    }
  }

  private implicit def tuple2Interval(t: (Int, Int)): Interval =
    new Interval(t._1, t._2)

  testCase(List.empty, List.empty)

  testCase(List(0 -> 1), List(0 -> 1))

  testCase(List(0 -> 1, 0 -> 2, 0 -> 5), List(0 -> 5))

  testCase(List(0 -> 1, 1 -> 2), List(0 -> 2))

  testCase(List(0 -> 1, 2 -> 2), List(0 -> 1, 2 -> 2))

  testCase(List(1 -> 3, 2 -> 6, 8 -> 10, 15 -> 18), List(1 -> 6, 8 -> 10, 15 -> 18))
}
