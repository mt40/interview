package leetcode

import scala.annotation.tailrec

/**
  * Idea:
  * - We start with 2 pointers, 1 at the start and 1 at the end.
  * this way, we already cover the case where we have the longest length.
  * - Each iteration, we move the pointer pointing to the shorter
  * column inward. Because we hope that we may find a higher column
  * that may increase the area.
  *
  * Time: O(n)
  */
object ContainerWithMostWater {

  def maxArea(heights: Array[Int]): Int = {
    @tailrec
    def loop(l: Int, r: Int, rs: Int): Int = {
      if (l >= r) {
        rs
      }
      else {
        val area = math.min(heights(l), heights(r)) * (r - l)
        val rsHere = math.max(rs, area)
        if (heights(l) < heights(r)) loop(l + 1, r, rsHere)
        else loop(l, r - 1, rsHere)
      }
    }

    loop(0, heights.length - 1, 0)
  }
}
