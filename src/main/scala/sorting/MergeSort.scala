package sorting

/**
  * Sorts a given array by recursively dividing the array by half
  * and sort each half.
  *
  * Best, worst, avg: O(n logn)
  *
  * @see https://en.wikipedia.org/wiki/Merge_sort
  */
class MergeSort extends Sorting {
  override def sort[A : Ordering](arr: Array[A]): Seq[A] = {
    // use Vector to avoid including ClassTag
    mergeSort(arr.toVector)
  }

  def mergeSort[A : Ordering](arr: Vector[A]): Vector[A] = {
    if (arr.length <= 1) {
      arr
    }
    else {
      val (left, right) = arr.splitAt(arr.length / 2)
      val sortedLeft = mergeSort(left)
      val sortedRight = mergeSort(right)
      merge(sortedLeft, sortedRight)
    }
  }

  def merge[A](left: Vector[A], right: Vector[A])(implicit ord: Ordering[A]): Vector[A] = {
    var rs = Vector.empty[A]
    var (i, j) = (0, 0)
    while (i < left.length && j < right.length) {
      if (ord.lteq(left(i), right(j))) {
        rs = rs :+ left(i)
        i += 1
      }
      else {
        rs = rs :+ right(j)
        j += 1
      }
    }

    // add remaining elements
    while (i < left.length) {
      rs = rs :+ left(i)
      i += 1
    }
    while (j < right.length) {
      rs = rs :+ right(j)
      j += 1
    }

    rs
  }
}
