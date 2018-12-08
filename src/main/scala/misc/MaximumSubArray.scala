package misc

import scala.annotation.tailrec

/**
  * Returns the sub-array (continuous) that has the highest sum
  * in the given non-empty array.
  * Time: O(n)
  */
object MaximumSubArray {

  private case class Result(start: Int, end: Int, sum: Int)

  def apply(nums: Array[Int]): Array[Int] = {
    @tailrec
    def loop(i: Int, tmpMax: Result, max: Result): Result = {
      if (i >= nums.length) {
        max
      }
      else {
        val elem = nums(i)
        val newTmp =
          if (elem > tmpMax.sum + elem) Result(i, i, elem)
          else tmpMax.copy(end = i, sum = tmpMax.sum + elem)

        if (newTmp.sum > max.sum) loop(i + 1, newTmp, newTmp)
        else loop(i + 1, newTmp, max)
      }
    }

    require(nums.nonEmpty)
    val max = Result(0, 0, nums.head)
    val rs = loop(1, max, max)
    nums.slice(rs.start, rs.end + 1)
  }
}
