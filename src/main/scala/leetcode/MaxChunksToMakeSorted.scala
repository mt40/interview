package leetcode

import scala.annotation.tailrec

/**
  * Observation: a chunk must contain the "sorted position" of the numbers inside it.
  * This means that for chunk [i..j] that contains x, i <= sortedIdx(x) <= j
  * Therefore, we only need to record the max number so far and if the property above
  * holds for it, we can cut a chunk.
  */
object MaxChunksToMakeSorted {

  def maxChunksToSorted(arr: Array[Int]): Int = {
    @tailrec
    def loop(i: Int, max: Int, rs: Int): Int = {
      if (i == arr.length) {
        rs
      }
      else {
        val newMax = math.max(arr(i), max)
        if (newMax > i) loop(i + 1, newMax, rs)
        else loop(i + 1, 0, rs + 1)
      }
    }

    loop(0, 0, 0)
  }
}
