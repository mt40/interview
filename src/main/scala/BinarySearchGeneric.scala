import scala.annotation.tailrec

/**
  * Returns the index of `x` in the given sorted array `arr`.
  * If `x` is not found, returns the index where `x` should be inserted
  * so that `arr` remains sorted.
  */
class BinarySearchGeneric {

  def run[A : Ordering](arr: Array[A], x: A): Int = {
    binSearch(arr, x, 0, arr.length - 1)
  }

  @tailrec
  final def binSearch[A](arr: Array[A], x: A, low: Int, hi: Int)(implicit ord: Ordering[A]): Int = {
    if(hi < low) {
      low
    }
    else {
      val pivot = (low + hi) / 2
      arr(pivot) match {
        case a if ord.equiv(x, a) => pivot
        case a if ord.lt(x, a)    => binSearch(arr, x, low, pivot - 1)
        case _                    => binSearch(arr, x, pivot + 1, hi)
      }
    }
  }
}
