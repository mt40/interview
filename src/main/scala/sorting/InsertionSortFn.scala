package sorting

import scala.annotation.tailrec

/**
  * Functional implementation.
  * We need a separate list to store the result. The idea is to try to insert
  * each element into the correct position in the result list.
  *
  * Best: O(n) (already sorted)
  * Worst & average: O(n^2)
  *
  *
  * @see https://github.com/vkostyukov/scalacaster/blob/master/src/sort/sorting.InsertionSort.scala
  */
class InsertionSortFn extends Sorting {
  override def sort[A : Ordering](arr: Array[A]): Seq[A] = {
    insertionSortFn(arr)
  }

  def insertionSortFn[A](arr: Array[A])(implicit ord: Ordering[A]): Seq[A] = {
    @tailrec
    def doSort(as: List[A], rs: List[A] = Nil): List[A] = {
      as match {
        case Nil => rs
        // try to insert `h` into the result list
        case h :: t => doSort(t, insert(h, rs))
      }
    }

    def insert(a: A, as: List[A]): List[A] = {
      as match {
        case h :: t if ord.lt(h, a) => h :: insert(a, t)
        case _                      => a :: as
      }
    }

    doSort(arr.toList)
  }
}
