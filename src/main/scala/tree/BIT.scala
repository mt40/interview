package tree

import scala.annotation.tailrec

class BIT private (val tree: Seq[Int]) {

  def length: Int = tree.length

  /**
    * Returns the sum of elements from index 0 to `to` (inclusive).
    * Time: O(logn)
    */
  def sum(to: Int): Int = {
    def loop(i: Int, rs: Int): Int = {
      if (i <= 0) rs
      else loop(childOf(i), rs + tree(i))
    }

    loop(indexOf(to), 0)
  }

  def sum(from: Int, to: Int): Int = {
    sum(to) - sum(from - 1)
  }

  /**
    * Returns a new tree representing the data updated with `value`
    * at index `idx`.
    *
    * Time: O(logn)
    */
  def update(idx: Int, value: Int): BIT = {
    @tailrec
    def loop(i: Int, newTree: Seq[Int]): Seq[Int] = {
      if (i >= length) newTree
      else loop(parentOf(i), newTree.updated(i, newTree(i) + value))
    }

    new BIT(loop(indexOf(idx), tree))
  }

  /** Returns the corresponding tree index of the given index. */
  private def indexOf(i: Int): Int = i + 1

  /**
    * Returns the index of the element that includes the sum at this index.
    * Basically, we add the right most 1-bit.
    * (e.g. 0011 -> 0100, the sum at index 3 is included in index 4)
    */
  private def parentOf(i: Int): Int = i + (i & -i)

  /** Returns the index of the element whose sum is included at `i`. */
  private def childOf(i: Int): Int = i - (i & -i)

  def toSeq: Seq[Int] = tree
}

object BIT {

  /**
    * Returns a BIT representing the given data.
    * Time: O(nlogn)
    */
  def apply(ints: Int*): BIT = {
    val empty = new BIT(Vector.fill(ints.length + 1)(0))
    ints.zipWithIndex.foldLeft(empty) { case (tree, (next, i)) => tree.update(i, next) }
  }
}
