package leetcode

import scala.annotation.tailrec

/**
  * Idea: if loop through a sorted list of all start time and end time,
  * whenever we see a start time, we need 1 more room. If we see an end time,
  * we release 1 room.
  *
  * Complexity: O(nlogn) where n is the number of intervals, this is because we
  * need to sort
  *
  * @see https://leetcode.com/problems/meeting-rooms-ii/
  */
object MeetingRoomsII {
  class Interval(val start: Int, val end: Int)

  def minMeetingRooms(intervals: Array[Interval]): Int = {
    val starts = intervals.map(_.start).sorted
    val ends = intervals.map(_.end).sorted

    @tailrec
    def loop(i: Int, j: Int, rooms: Int, rs: Int): Int = {
      if (i == starts.length) {
        rs
      }
      else {
        if (starts(i) < ends(j)) {
          loop(i + 1, j, rooms + 1, math.max(rs, rooms + 1))
        }
        else {
          loop(i, j + 1, rooms - 1, rs)
        }
      }
    }

    loop(0, 0, 0, 0)
  }
}
