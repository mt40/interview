package leetcode

import scala.annotation.tailrec

/** @see https://leetcode.com/problems/product-of-array-except-self/ */
object ProductOfArrayExceptSelf {

  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    val n = nums.length
    val output = Array.fill(n)(1)

    @tailrec
    def leftToRight(i: Int, acc: Int): Unit = {
      if (i < n) {
        output(i) = acc
        leftToRight(i + 1, acc * nums(i))
      }
    }

    @tailrec
    def rightToLeft(i: Int, acc: Int): Unit = {
      if (i >= 0) {
        output(i) *= acc
        rightToLeft(i - 1, acc * nums(i))
      }
    }

    leftToRight(1, nums(0))
    rightToLeft(n - 2, nums(n - 1))
    output
  }
}
