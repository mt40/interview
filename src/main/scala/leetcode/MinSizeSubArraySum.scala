package leetcode

import scala.annotation.tailrec

/**
  * Idea:
  * - have 2 pointers 'left' (l) and 'right' (r)
  * - each step, we advance `r` and try to advance `l`
  * to minimize the distant between the two as long as
  * their sum still satisfies the condition
  * - each step, if sum[l, r] >= target, record it
  */
object MinSizeSubArraySum {

  def minSubArrayLen(target: Int, nums: Array[Int]): Int = {
    @tailrec
    def loop(l: Int, r: Int, tmpSum: Int, minLen: Int): Int = {
      if (r >= nums.length) {
        minLen
      }
      else {
        var sumHere = tmpSum + nums(r)
        var i = l
        while (i < r && sumHere - nums(i) >= target) {
          sumHere -= nums(i)
          i += 1
        }
        val min = if (sumHere >= target) math.min(r - i + 1, minLen) else minLen
        loop(i, r + 1, sumHere, min)
      }
    }

    if (nums.sum < target) 0 else loop(0, 0, 0, nums.length)
  }
}
