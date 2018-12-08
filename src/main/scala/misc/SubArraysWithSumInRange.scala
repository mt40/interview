package misc

import scala.annotation.tailrec
import scala.collection.immutable.TreeMap

/**
  * Returns the number of sub-array whose sum falls within
  * the given range.
  *
  * Time: O(nlogn)
  *
  * Idea: same as "SubArrayWithSumK", only this time, we need to count how many
  * prefix sums fall in a range. We can do that efficiently using `TreeMap` since
  * it is implemented using RB Tree.
  */
object SubArraysWithSumInRange {

  def apply(nums: List[Int], range: Range): Int = {
    @tailrec
    def loop(l: List[Int], accSum: Int, prefixSum: TreeMap[Int, Int], rs: Int): Int = {
      l match {
        case Nil => rs
        case h :: t =>
          val sumHere = accSum + h
          val low = sumHere - range.end
          val hi = sumHere - range.start
          val inRange = prefixSum.from(low).to(hi)
          val rsHere = rs + inRange.values.sum
          val prefixSumHere = prefixSum.updated(sumHere, prefixSum.getOrElse(sumHere, 0) + 1)
          loop(t, sumHere, prefixSumHere, rsHere)
      }
    }

    // there is always an empty sub-array with sum 0
    val prefixSum = TreeMap(0 -> 1)
    loop(nums, 0, prefixSum, 0)
  }
}
