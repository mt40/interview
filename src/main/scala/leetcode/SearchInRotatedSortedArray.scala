package leetcode

import scala.annotation.tailrec

/**
  * Idea: find the pivot point first and then base on the first element,
  * we decide to do binary search on the left or on the right
  *
  * Complexity: O(logn)
  *
  * @see https://leetcode.com/problems/search-in-rotated-sorted-array/
  */
object SearchInRotatedSortedArray {

  def search(nums: Array[Int], target: Int): Int = {
    if (nums.isEmpty) {
      -1
    }
    else {
      val pivot = findPivot(nums)
      if (nums(0) <= target) binSearch(nums, target, 0, pivot)
      else binSearch(nums, target, pivot + 1, nums.length - 1)
    }
  }

  def findPivot(ints: Array[Int]): Int = {
    @tailrec
    def loop(i: Int): Int = {
      if (i + 1 == ints.length || ints(i) > ints(i + 1)) i
      else loop(i + 1)
    }

    loop(0)
  }

  @tailrec
  def binSearch(ints: Array[Int], target: Int, low: Int, hi: Int): Int = {
    if (low > hi) {
      -1
    }
    else {
      val mid = low + (hi - low) / 2
      if (ints(mid) == target) mid
      else if (ints(mid) < target) binSearch(ints, target, mid + 1, hi)
      else binSearch(ints, target, low, mid - 1)
    }
  }
}
