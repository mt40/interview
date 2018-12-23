package leetcode

import scala.annotation.tailrec

/**
  * Idea: we fix 1 element and try to find the other 2. Since finding 2 elements
  * can be done in O(n). Overall complexity is O(n^2).
  */
object ThreeSumClosest {

  def threeSumClosest(nums: Array[Int], target: Int): Int = {
    val sorted = nums.sorted
    val state = (Int.MaxValue, Int.MaxValue)
    (0 to sorted.length - 3).foldLeft(state) {
      case ((sum, diff), i) =>
        val first = sorted(i)
        val threeSum = twoSumClosest(sorted, i + 1, target - first) + first
        val newDiff = math.abs(target - threeSum)
        if (newDiff < diff) (threeSum, newDiff)
        else (sum, diff)
    }._1
  }

  /** @param sorted must be already sorted */
  private def twoSumClosest(sorted: Array[Int], start: Int, target: Int): Int = {
    @tailrec
    def loop(l: Int, r: Int, sum: Int, minDiff: Int): Int = {
      if (l >= r) {
        sum
      }
      else {
        val sumHere = sorted(l) + sorted(r)
        val diffHere = math.abs(sumHere - target)
        val newSum = if(diffHere < minDiff) sumHere else sum
        val newDiff = math.min(diffHere, minDiff)

        if (diffHere == 0) sumHere
        else if (sumHere > target) loop(l, r - 1, newSum, newDiff)
        else loop(l + 1, r, newSum, newDiff)
      }
    }

    loop(start, sorted.length - 1, Int.MaxValue, Int.MaxValue)
  }
}
