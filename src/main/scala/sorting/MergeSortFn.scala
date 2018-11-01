package sorting

import scala.annotation.tailrec

/**
  * Functional implementation.
  *
  * The difference is when merging, we need a new list to store the result.
  * This result however is reversed, because we are appending the smaller
  * element in each iteration. So we have to reverse it after merge.
  *
  * Best, worst & avg: O(n logn)
  *
  * @see https://github.com/vkostyukov/scalacaster/blob/master/src/sort/sorting.MergeSort.scala
  */
class MergeSortFn extends Sorting {
  override def sort[A : Ordering](arr: Array[A]): Seq[A] = {
    mergeSortFn(arr)
  }

  def mergeSortFn[A](arr: Array[A])(implicit ord: Ordering[A]): Seq[A] = {
    def doSort(as: List[A]): List[A] = {
      if (as.length <= 1) {
        as
      }
      else {
        val (left, right) = as.splitAt(as.length / 2)
        val sortedLeft = doSort(left)
        val sortedRight = doSort(right)
        merge(sortedLeft, sortedRight).reverse
      }
    }

    @tailrec
    def merge(left: List[A], right: List[A], rs: List[A] = Nil): List[A] = {
      (left, right) match {
        case (lh :: lt, rh :: rt) =>
          if (ord.lteq(lh, rh)) merge(lt, right, lh :: rs)
          else merge(left, rt, rh :: rs)
        case (lh :: lt, Nil) =>
          merge(lt, Nil, lh :: rs)
        case (Nil, rh :: rt) =>
          merge(Nil, rt, rh :: rs)
        case (Nil, Nil) => rs
      }
    }

    doSort(arr.toList)
  }
}
