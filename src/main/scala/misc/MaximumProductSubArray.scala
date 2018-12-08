package misc

import scala.annotation.tailrec

/**
  * Returns largest product of a sub-array (continuous)
  * in the given non-empty array.
  *
  * Idea: since a smallest product can become the largest
  * if we multiply it with a negative number, we have to
  * record the smallest product after each iteration.
  * The rest is similar to Maximum (Sum) Sub-array.
  *
  * Time: O(n)
  */
object MaximumProductSubArray {

  def apply(nums: Array[Int]): Int = {
    require(nums.nonEmpty)

    @tailrec
    def loop(i: Int, tmp: Int, negTmp: Int, rs: Int): Int = {
      if (i == nums.length) {
        rs
      }
      else {
        val prod = tmp * nums(i)
        val negProd = negTmp * nums(i)
        val tmp2 = Seq(nums(i), prod, negProd).max
        val negTmp2 = Seq(nums(i), prod, negProd).min
        val max = math.max(rs, tmp2)
        loop(i + 1, tmp2, negTmp2, max)
      }
    }

    loop(1, nums.head, nums.head, nums.head)
  }
}
