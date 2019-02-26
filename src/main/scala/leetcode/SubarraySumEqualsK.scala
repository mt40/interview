package leetcode

import scala.annotation.tailrec

/**
  * Complexity: O(n)
  * @see https://leetcode.com/problems/subarray-sum-equals-k
  */
object SubarraySumEqualsK {

  def subarraySum(nums: Array[Int], k: Int): Int = {
    @tailrec
    def loop(i: Int, accSum: Int, seen: Map[Int, Int], rs: Int): Int = {
      if (i == nums.length) {
        rs
      }
      else {
        val sumHere = accSum + nums(i)
        val newRs = {
          val prev = rs + seen.getOrElse(sumHere - k, 0)
          if(sumHere == k) prev + 1 else prev
        }
        val newSeen = seen.updated(sumHere, 1 + seen.getOrElse(sumHere, 0))
        loop(i + 1, sumHere, newSeen, newRs)
      }
    }

    loop(0, 0, Map.empty, 0)
  }
}
