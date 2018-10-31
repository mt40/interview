import common.Sorting

import scala.annotation.tailrec

/**
  * Sorts a given array by comparing 2 adjacent elements at a time
  * and swap them if they are not in order. Then we traverse the
  * array and do that again until there is no pair that needs to be
  * swapped.
  *
  * Best: O(n) (when already sorted)
  * Worst & average: O(n^2)
  *
  * @see https://en.wikipedia.org/wiki/Bubble_sort
  */
class BubbleSort extends Sorting {

  def sort[A : Ordering](arr: Array[A]): Seq[A] = {
    bubbleSort(arr)
  }

  @tailrec
  final def bubbleSort[A](arr: Array[A])(implicit ord: Ordering[A]): Array[A] = {
    var stop = true
    var bound = arr.length // we don't need to care about elements after this index
    for(i <- 1 until bound) {
      val a1 = arr(i - 1)
      val a2 = arr(i)
      if(ord.lt(a2, a1)) {
        // swap
        val tmp = arr(i - 1)
        arr(i - 1) = arr(i)
        arr(i) = tmp
        stop = false
      }
      bound -= 1
    }
    if(stop) arr else bubbleSort(arr)
  }
}
