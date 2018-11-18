package tree

import scala.annotation.tailrec

/**
  * Max Binary Heap implementation.
  * @see https://www.wikiwand.com/en/Binary_heap
  */
class Heap[A : Ordering] private () {
  def size: Int = internalSize

  private def ord: Ordering[A] = implicitly

  private var internalSize = 0

  private val initialSize = 3

  private var data: Array[Option[A]] = Array.fill(initialSize)(None)

  private def leftChild(node: Int): Int = 2 * node + 1

  private def rightChild(node: Int): Int = leftChild(node) + 1

  private def parent(node: Int): Int = (node - 1) / 2

  private def heir(node: Int): Int = {
    val (l, r) = (leftChild(node), rightChild(node))
    val (left, right) = (data(l), data(r))
    // prioritize the left child so that we don't have holes in our array
    if (right.isEmpty || ord.gteq(left.get, right.get)) l
    else r
  }

  private def isLeaf(node: Int): Boolean = leftChild(node) >= internalSize

  /**
    * Add the given element into this heap.
    * Time: O(logn)
    */
  final def add(a: A)(implicit ord: Ordering[A]): Heap[A] = {
    if (internalSize == data.length) grow()
    data(internalSize) = Some(a)
    upHeap(internalSize)
    internalSize += 1
    this
  }

  /**
    * Removes the 1st (maximum) element from this heap.
    * Time: O(logn)
    */
  final def remove(): A = {
    if (internalSize == 0) {
      throw new NoSuchElementException("heap is empty")
    }
    else {
      val root = data(0)
      data(0) = data(internalSize - 1)
      internalSize -= 1
      downHeap(0)
      root.get
    }
  }

  @tailrec
  private def upHeap(node: Int): Unit = {
    if (node > 0) {
      val p = parent(node)
      if (ord.lt(data(p).get, data(node).get)) {
        swap(data, p, node)
        upHeap(p)
      }
    }
  }

  @tailrec
  private def downHeap(node: Int): Unit = {
    if (!isLeaf(node)) {
      val toSwap = heir(node)
      swap(data, node, toSwap)
      downHeap(toSwap)
    }
  }

  /** Increases the capacity of the internal array. */
  private def grow(): Unit = {
    val newSize = math.ceil(internalSize * 2).toInt
    val bigger: Array[Option[A]] = Array.fill(newSize)(None)
    data.copyToArray(bigger)
    data = bigger
  }

  private def swap[T](arr: Array[T], i: Int, j: Int): Unit = {
    val tmp = arr(i)
    arr(i) = arr(j)
    arr(j) = tmp
  }

  final def toSeq: Seq[A] = data.slice(0, internalSize).map(_.get)
}

object Heap {
  def empty[A : Ordering]: Heap[A] = new Heap()

  def apply[A : Ordering](as: A*): Heap[A] = {
    as.foldLeft(empty[A])((h, a) => h.add(a))
  }
}
