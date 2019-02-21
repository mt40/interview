package leetcode

import common.SolutionSuite
import leetcode.MeetingRoomsII.Interval
import language.implicitConversions

class MeetingRoomsIISuite extends SolutionSuite {
  private def testCase(intervals: Array[Interval], expect: Int) = {
    val str = intervals.map(i => s"${i.start}->${i.end}").mkString(", ")
    test(s"Meeting rooms for: $str") {
      MeetingRoomsII.minMeetingRooms(intervals) shouldEqual expect
    }
  }

  private implicit def tuple2Interval(t: (Int, Int)): Interval =
    new Interval(t._1, t._2)

  testCase(Array[Interval](0 -> 3), 1)
  testCase(Array[Interval](0 -> 3, 1 -> 3), 2)
  testCase(Array[Interval](0 -> 1, 2 -> 3), 1)
  testCase(Array[Interval](0 -> 1, 1 -> 3), 1)
  testCase(Array[Interval](0 -> 5, 2 -> 3, 2 -> 3, 4 -> 8, 7 -> 10), 3)
}
