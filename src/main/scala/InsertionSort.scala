import common.Sorting

/**
  * Sorts a given array by moving each element to its correct position
  * on the left.
  *
  * Best: O(n) (already sorted)
  * Worst & average: O(n^2)
  *
  * @see https://en.wikipedia.org/wiki/Insertion_sort
  */
class InsertionSort extends Sorting {

  def sort[A : Ordering](arr: Array[A]): Seq[A] = {
    insertionSort(arr)
  }

  def insertionSort[A](arr: Array[A])(implicit ord: Ordering[A]): Array[A] = {
    for (i <- 1 until arr.length) {
      for (j <- i to 1 by -1 if ord.lt(arr(j), arr(j - 1))) {
        val tmp = arr(j)
        arr(j) = arr(j - 1)
        arr(j - 1) = tmp
      }
    }
    arr
  }
}
