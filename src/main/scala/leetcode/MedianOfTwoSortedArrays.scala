package leetcode

import scala.annotation.tailrec

/**
  * Computes the median of all the elements in the 2 given sorted arrays.
  * Idea:
  *   - Observation: there should be equal number of elements
  *   smaller than and larger than the median. We try to check this fact
  *   for each a(i), and go left or right of a depends on the number of
  *   smaller elements in both arrays.
  *
  * Time: O(logn + logm)) where n & m are length of the 2 arrays
  *
  * @note there is another approach running in O(log(n+m)) using an idea
  *       similar to binary search. But it is very difficult to code
  *       correctly.
  */
object MedianOfTwoSortedArrays {

  def findMedianSortedArrays(a: Array[Int], b: Array[Int]): Double = {
    if (a.isEmpty) median(b)
    else if (b.isEmpty) median(a)
    else solve(a, b, 0, a.length - 1)
  }

  @tailrec
  private def solve(a: Array[Int], b: Array[Int], l: Int, r: Int): Double = {
    val aMid = (l + r) / 2
    val m = a(aMid) // temporary median
    val smallerInA = aMid // number of smaller elements in a

    val half = (a.length + b.length) / 2
    val smallerNeedInB = half - smallerInA

    // median is not in a, switch a & b to search in b
    if (l > r) {
      solve(b, a, 0, b.length - 1)
    }
    else {
      val j = smallerNeedInB - 1

      // if there are too many smaller elements in b, then m is too big
      if (j + 1 < 0 || (j + 1 < b.length && b(j + 1) < m)) {
        solve(a, b, l, aMid - 1)
      }
      // if there is not enough smaller elements, then m is too small
      else if (j >= b.length || (j >= 0 && m < b(j))) {
        solve(a, b, aMid + 1, r)
      }
      else {
        // total length is odd, there is only 1 median
        if (!isEven(a.length + b.length)) {
          m
        }
        else {
          // total length is even, there are 2 medians
          // the 1st (bigger) one is m, the 2nd one is either
          // a(aMid + 1) or b(j), whichever bigger
          if (aMid == 0 || (j >= 0 && b(j) > a(aMid - 1))) (m + b(j)) / 2.0
          else (m + a(aMid - 1)) / 2.0
        }
      }
    }
  }

  private[leetcode] def median(arr: Array[Int]): Double = {
    val n = arr.length
    val mid = n / 2
    if (isEven(n)) (arr(mid) + arr(mid - 1)) / 2.0
    else arr(mid)
  }

  private def isEven(i: Int): Boolean = i % 2 == 0
}
