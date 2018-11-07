package collection

/**
  * A mutable implementation of queue.
  * This is my go-to implementation when I was using Java in the past.
  */
class LinkedQueue[A](private var first: Option[QNode[A]], private var last: Option[QNode[A]]) {

  def front: QNode[A] = first.get

  def isEmpty: Boolean = first.isEmpty

  /**
    * Adds the given element in to the end of this queue.
    * Time: O(1)
    */
  def enqueue(a: A): Unit = {
    val newNode = QNode(a)
    if (isEmpty) {
      first = Some(newNode)
      last = Some(newNode)
    }
    else {
      last.get.next = Some(newNode)
      last = Some(newNode)
    }
  }

  /**
    * Pops the element at the front of this queue.
    * Time: O(1)
    */
  def dequeue: A = {
    (first, last) match {
      case (None, _) => throw new NoSuchElementException("queue is empty")
      case (Some(f), _) if first == last =>
        first = None
        last = None
        f.value
      case (Some(f), _) =>
        val tmp = f.value
        first = f.next
        tmp
    }
  }
}

object LinkedQueue {
  def empty[A]: LinkedQueue[A] = new LinkedQueue(None, None)

  def apply[A](as: A*): LinkedQueue[A] = {
    val q = empty[A]
    as.foreach(a => q enqueue a)
    q
  }
}

case class QNode[A](value: A, var next: Option[QNode[A]] = None)

object QNode {

  def apply[A](value: A, next: QNode[A]): QNode[A] = {
    QNode(value, Some(next))
  }
}
