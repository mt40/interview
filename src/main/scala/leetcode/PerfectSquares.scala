package leetcode

import scala.collection.mutable

/**
  * Idea:
  * - dp(i) is the result of i
  * - dp(i) is min of i (if we pick the perfect square as 1)
  * and 1 + dp(i - k*k), where k is from 1 to sqrt(i)
  *
  * Complexity: O(n * sqrt(n))
  *
  * @see https://leetcode.com/problems/perfect-squares/
  */
object PerfectSquares {

  def numSquares(n: Int): Int = {
    val cache = mutable.Map.empty[Int, Int]

    def dp(i: Int): Int = {
      if (cache.contains(i)) {
        cache(i)
      }
      else {
        // max result is itself, when all perfect squares are 1
        val rs = (1 to math.sqrt(i).toInt).foldLeft(i) { (acc, k) =>
          math.min(acc, 1 + dp(i - k * k))
        }
        cache.update(i, rs)
        rs
      }
    }

    dp(n)
  }
}
