package misc

import scala.annotation.tailrec

/**
  * Returns number of sub-arrays whose sum = k.
  * Idea:
  *   - Observation: if sub-array [i..j] has sum = k then
  *   prefix_sum(j) - prefix_sum(i - 1) = k
  *   - So while we iterate each element from left to right
  *   and record the accumulated sum (i.e. prefix sum), we have
  *   result += prefix_sum(acc_sum - k)
  *
  * Time: O(n)
  */
object SubArrayWithSumK {

  def apply(nums: Seq[Int], k: Int): Int = {
    @tailrec
    def loop(remain: Seq[Int], accSum: Int, prefixSum: Map[Int, Int], rs: Int): Int = {
      if (remain.isEmpty) {
        rs
      }
      else {
        val sumHere = accSum + remain.head
        val updated = prefixSum.updated(sumHere, prefixSum.getOrElse(sumHere, 0) + 1)
        val rsHere = rs + prefixSum.getOrElse(sumHere - k, 0)
        loop(remain.tail, sumHere, updated, rsHere)
      }
    }

    loop(nums, 0, Map(0 -> 1), 0)
  }
}
