package collection

import scala.annotation.tailrec

/**
  * A functional implementation of the Queue data structure.
  * This implementation is also known as Banker's Queue.
  *
  * The idea is to maintain 2 internal lists to keep the left
  * part (where new elements are inserted) and the right part of
  * the queue (where elements are removed). If the right part
  * is empty, we move elements from the left part to it.
  *
  * @see https://en.wikipedia.org/wiki/Queue_(abstract_data_type)
  * @see https://github.com/vkostyukov/scalacaster/blob/master/src/collection/Queue.scala
  */
case class BankersQueue[+A](private val in: List[A] = Nil, private val out: List[A] = Nil) {

  def isEmpty: Boolean = in.isEmpty && out.isEmpty

  /**
    * Adds the given value to the end of this queue.
    * Time: O(1)
    */
  final def enqueue[B >: A](x: B): BankersQueue[B] = {
    new BankersQueue[B](x :: in, out)
  }

  /**
    * Returns the value at the front of this queue and
    * a the rest of this queue.
    *
    * Time: O(1)
    */
  @tailrec
  final def dequeue: (A, BankersQueue[A]) = {
    out match {
      case h :: t => (h, new BankersQueue(in, t))
      case Nil =>
        if (in.nonEmpty) new BankersQueue(Nil, in.reverse).dequeue
        else throw new NoSuchElementException("queue is empty")
    }
  }
}

object BankersQueue {
  def empty[A]: BankersQueue[A] = new BankersQueue[A]()

  def apply[A](as: A*): BankersQueue[A] = {
    as.foldLeft(empty[A])((q, a) => q enqueue a)
  }
}
