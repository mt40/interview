package sorting

class QuickSortFn extends Sorting {
  override def sort[A : Ordering](arr: Array[A]): Seq[A] = {
    quickSortFn(arr)
  }

  private def quickSortFn[A](arr: Array[A])(implicit ord: Ordering[A]): Seq[A] = {
    def doSort(as: List[A]): List[A] = {
      if (as.length <= 1) {
        as
      }
      else {
        // we choose the 1st element as pivot. Although this is not always efficient
        // (e.g. when list is already sorted), it makes the implementation easier
        val pivot = as.head
        val (left, right) = as.tail.partition(a => ord.lteq(a, pivot))
        doSort(left) ++ (pivot :: doSort(right))
      }
    }

    doSort(arr.toList)
  }
}
