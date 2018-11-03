package sorting

import scala.annotation.tailrec

class QuickSortFn extends Sorting {
  override def sort[A : Ordering](arr: Array[A]): Seq[A] = {
    quickSortFn(arr)
  }

  def quickSortFn[A](arr: Array[A])(implicit ord: Ordering[A]): Seq[A] = {
    def doSort(as: List[A]): List[A] = {
      if (as.length <= 1) {
        as
      }
      else {
        val (left, pivot, right) = partition(as)
        doSort(left) ++ (pivot :: doSort(right))
      }
    }

    def partition(as: List[A]): (List[A], A, List[A]) = {
      @tailrec
      def loop(p: A, remain: List[A], left: List[A], right: List[A]): (List[A], A, List[A]) = {
        remain match {
          case h :: t =>
            if (ord.lteq(h, p)) loop(p, t, h :: left, right)
            else loop(p, t, left, h :: right)
          case Nil => (left, p, right)
        }
      }

      // we choose the 1st element as pivot. Although this is not always efficient
      // (e.g. when list is already sorted), it makes the implementation easier
      loop(as.head, as.tail, Nil, Nil)
    }

    doSort(arr.toList)
  }
}
