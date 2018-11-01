package searching

import scala.annotation.tailrec

/**
  * Returns the index of `x` in the given sorted array `arr`.
  * If `x` is not found, returns the index where `x` should be inserted
  * so that `arr` remains sorted.
  */
class BinarySearch {

  def run(arr: Array[Int], x: Int): Int = {
    binSearch(arr, x, 0, arr.length - 1)
  }

  @tailrec
  final def binSearch(arr: Array[Int], x: Int, low: Int, hi: Int): Int = {
    if (hi < low) {
      low
    }
    else {
      val pivot = (low + hi) / 2
      arr(pivot) match {
        case a if a == x => pivot
        case a if x < a  => binSearch(arr, x, low, pivot - 1)
        case _           => binSearch(arr, x, pivot + 1, hi)
      }
    }
  }
}
