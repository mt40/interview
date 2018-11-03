package sorting

/**
  * Sorts the given array by putting the pivot element into
  * its "sorted" position. Then we sort the sub-array on
  * its left and the sub-array on its right. Do that recursively.
  *
  * Best: O(n logn)
  * Avg: O(n logn)
  * Worst: O(n^2)
  *
  * @see https://en.wikipedia.org/wiki/Quicksort
  */
class QuickSort extends Sorting {
  override def sort[A : Ordering](arr: Array[A]): Seq[A] = {
    val sorted = quickSort1(arr)
    assert(sorted == quickSort2(arr))
    sorted
  }

  /**
    * Implementation using Hoare partition scheme.
    *
    * The idea is using 2 pointers, 1 at the start and 1 at the end. We
    * move them toward each other. Whenever we find a pair of elements
    * not in sorted order, we swap them.
    *
    * This implementation is a little bit hard to understand all the corner
    * cases.
    *
    * @see https://en.wikipedia.org/wiki/Quicksort#Hoare_partition_scheme
    */
  def quickSort1[A](arr: Array[A])(implicit ord: Ordering[A]): Seq[A] = {
    def doSort(arr: Array[A], low: Int, hi: Int): Unit = {
      // we are choosing the middle element as pivot. This can give us the
      // worse case performance with input like: [1 2, 3, 5, 1, 2, 3]
      // There are other ways to choose pivot like: 1st element, last element,
      // median-of-three, random ...
      val p = (low + hi) / 2
      val pivot = arr(p)
      var (i, j) = (low, hi)

      while (i <= j) {
        while (ord.lt(arr(i), pivot)) i += 1
        while (ord.lt(pivot, arr(j))) j -= 1
        if (i <= j) {
          // swap
          val tmp = arr(i)
          arr(i) = arr(j)
          arr(j) = tmp
          i += 1
          j -= 1
        }
      }

      // recursively sort the left and right sub-arrays
      // we cannot divide `arr` using `p` because the pivot
      // element can move during the swapping process above
      if (low < j) doSort(arr, low, j)
      if (i < hi) doSort(arr, i, hi)
    }

    if (!arr.isEmpty) doSort(arr, 0, arr.length - 1)
    arr
  }

  /**
    * Another implementation using a simpler partitioning scheme called Lomuto.
    * The idea is choosing the last element to be the pivot. Then we iterate
    * the remaining elements and move the ones smaller than the pivot to the
    * prefix of the array (lets call it P). Finally, we just move the pivot
    * from the last position to after the end of P.
    *
    * This method is easier to understand but requires more swaps than
    * the 1st method.
    *
    * @see https://en.wikipedia.org/wiki/Quicksort#Lomuto_partition_scheme
    */
  def quickSort2[A](arr: Array[A])(implicit ord: Ordering[A]): Seq[A] = {
    def doSort(arr: Array[A], low: Int, hi: Int): Unit = {
      if (low < hi) {
        val p = partition(arr, low, hi)
        doSort(arr, low, p - 1)
        doSort(arr, p + 1, hi)
      }
    }

    def partition(arr: Array[A], low: Int, hi: Int): Int = {
      val pivot = arr(hi)
      var i = low
      for (j <- low to hi - 1) {
        if (ord.lt(arr(j), pivot)) {
          if (i != j) swap(arr, i, j)
          i += 1
        }
      }
      swap(arr, i, hi)
      i
    }

    def swap(arr: Array[A], i: Int, j: Int): Unit = {
      val tmp = arr(i)
      arr(i) = arr(j)
      arr(j) = tmp
    }

    doSort(arr, 0, arr.length - 1)
    arr
  }
}
