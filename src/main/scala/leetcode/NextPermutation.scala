package leetcode

/**
  * Idea:
  * - Find the longest decreasing sub-array R at the end of this array.
  * - In R, find the min element that is larger than the last element of the left part.
  * - Swap those 2
  * - Now reverse R.
  * - If the left array is empty, this means the current permutation is the largest,
  * return its reverse.
  *
  * In summary, the key point is to recognize at the end of each permutation is a decreasing
  * array.
  *
  * Complexity: O(n)
  *
  * @see https://leetcode.com/problems/next-permutation
  */
object NextPermutation {

  def nextPermutation(nums: Array[Int]): Unit = {
    val n = nums.length
    if (n > 1) {
      // from i + 1 to end is the decreasing sub-array
      var i = n - 2
      while (i >= 0 && nums(i) >= nums(i + 1)) i -= 1

      if (i < 0) {
        reverse(nums, 0)
      }
      else {
        val minLarger = nums.lastIndexWhere(_ > nums(i))
        swap(nums, i, minLarger)
        reverse(nums, i + 1)
      }
    }
  }

  private def swap(arr: Array[Int], i: Int, j: Int): Unit = {
    val tmp = arr(i)
    arr(i) = arr(j)
    arr(j) = tmp
  }

  private def reverse(arr: Array[Int], start: Int): Unit = {
    val n = (start until arr.length).length
    for (i <- 0 until n / 2) {
      val j = n - 1 - i
      swap(arr, i + start, j + start)
    }
  }
}
