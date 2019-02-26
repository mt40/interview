package leetcode

import scala.annotation.tailrec

/**
  * Complexity: O(n)
  *
  * @see https://leetcode.com/problems/subarray-sum-equals-k
  */
object DailyTemperatures {

  def dailyTemperatures(temperatures: Array[Int]): Array[Int] = {
    @tailrec
    def loop(i: Int, stack: List[Int], rs: List[Int]): List[Int] = {
      if (i < 0) {
        rs
      }
      else {
        stack match {
          case Nil => loop(i - 1, i :: stack, 0 :: rs)
          case h :: t =>
            if (temperatures(i) < temperatures(h)) {
              loop(i - 1, i :: stack, (h - i) :: rs)
            }
            else {
              loop(i, t, rs)
            }
        }
      }
    }

    loop(temperatures.length - 1, List.empty, List.empty).toArray
  }
}
