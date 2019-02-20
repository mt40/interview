package leetcode

/**
  * Idea: sort and use stack
  * Complexity: O(n)
  *
  * @see https://leetcode.com/problems/merge-intervals/
  */
object MergeIntervals {

  class Interval(val start: Int, val end: Int) {
    override def toString: String = s"[$start, $end]"

    override def hashCode(): Int = (start, end).hashCode()

    override def equals(obj: Any): Boolean = {
      obj match {
        case i: Interval => start == i.start && end == i.end
        case _           => false
      }
    }
  }

  def merge(intervals: List[Interval]): List[Interval] = {
    val stack = List.empty[Interval]
    val sorted = intervals.sortBy(_.start)
    sorted.foldLeft(stack) { (st, next) =>
      if (st.isEmpty || next.start > st.head.end) {
        next +: st
      }
      else {
        val i = new Interval(st.head.start, math.max(next.end, st.head.end))
        i +: st.tail
      }
    }
  }
}
