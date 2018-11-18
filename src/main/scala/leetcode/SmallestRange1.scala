package leetcode

/**
  * Idea: actually we only need to minimizing the difference between
  * the maximum and minimum elements.
  */
object SmallestRange1 {

  def smallestRangeI(nums: Array[Int], k: Int): Int = {
    val min = nums.min
    val max = nums.max

    val min2 = math.min(min + k, max)
    val max2 = math.max(max - k, min2)

    max2 - min2
  }
}
