package leetcode

import scala.annotation.tailrec

/**
  * Idea: simply do binary search, if the current trend is increasing,
  * then go to the right. Otherwise, go left.
  *
  * Complexity: O(logn)
  *
  * @see https://leetcode.com/problems/find-peak-element/
  */
object FindPeakElement {

  def findPeakElement(nums: Array[Int]): Int = {
    def lessThan(i: Int, j: Int): Boolean = {
      if (i == -1) true
      else if (j == nums.length) false
      else nums(i) < nums(j)
    }

    @tailrec
    def binSearch(low: Int, hi: Int): Int = {
      if (low == hi) {
        low
      }
      else {
        val mid = low + (hi - low) / 2
        if (lessThan(mid, mid + 1)) { // increasing
          binSearch(mid + 1, hi)
        }
        else { // decreasing
          binSearch(low, mid)
        }
      }
    }

    binSearch(0, nums.length - 1)
  }
}
