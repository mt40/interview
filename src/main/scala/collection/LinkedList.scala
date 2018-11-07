package collection

import scala.annotation.tailrec

sealed trait LinkedList[+A] {
  def head: A

  def tail: LinkedList[A]

  def isEmpty: Boolean

  /**
    * Returns the length (i.e. number of elements) of this list.
    * Time: O(n)
    */
  def length: Int = {
    if (this.isEmpty) 0 else 1 + tail.length
  }

  /**
    * Returns a new list with the given element appended
    * Time: O(1)
    */
  def prepend[B >: A](x: B): LinkedList[B] = Node(x, this)

  /**
    * Returns a new list that contains elements of this list
    * followed by elements of `other`.
    *
    * Time: O(n) where n is the length of this list
    */
  def concat[B >: A](other: LinkedList[B]): LinkedList[B] = {
    if (this.isEmpty) other
    else (tail concat other) prepend head
  }

  /**
    * Returns a new list that is the reverse of this list.
    * Time: O(n)
    */
  def reversed: LinkedList[A] = {
    @tailrec
    def loop(l: LinkedList[A], rs: LinkedList[A]): LinkedList[A] = {
      l match {
        case Empty      => rs
        case Node(h, t) => loop(t, rs prepend h)
      }
    }

    loop(this, Empty)
  }

  /**
    * Returns a new list containing the result of applying `f`
    * to all elements of this list.
    *
    * Time: O(n)
    */
  def map[B](f: A => B): LinkedList[B] = {
    flatMap(a => LinkedList(f(a)))
  }

  /**
    * Returns a new list containing the elements from the result of
    * applying `f` to all elements of this list.
    *
    * Time: O(n * m) where m is the length of
    */
  def flatMap[B](f: A => LinkedList[B]): LinkedList[B] = {
    def loop(l: LinkedList[A], rs: LinkedList[B]): LinkedList[B] = {
      l match {
        case Empty      => rs
        case Node(h, t) => f(h) concat loop(t, rs)
      }
    }

    loop(this, Empty)
  }

  /**
    * Returns the element at the given index.
    * Time: O(n)
    */
  @tailrec
  final def apply(i: Int): A = {
    if (i < 0 || i >= this.length) throw new IndexOutOfBoundsException("" + i)
    if (i == 0) head else tail.apply(i - 1)
  }

  /**
    * Returns `true` if the given value is in this list and `false` otherwise.
    * Time: O(n)
    */
  def contains[B >: A](x: B): Boolean = {
    if (this.isEmpty) false
    else if (head == x) true
    else tail.contains(x)
  }

  /**
    * Applies an operator `f` to a start value `z`
    * and all elements (from left to right).
    */
  @tailrec
  final def foldLeft[B](z: B)(f: (B, A) => B): B = {
    if (this.isEmpty) z
    else tail.foldLeft(f(z, head))(f)
  }

  /** Returns a new list whose elements satisfies the given predicate. */
  def filter(p: A => Boolean): LinkedList[A] = {
    flatMap(a => if (p(a)) LinkedList(a) else Empty)
  }
}

object LinkedList {
  def empty[A]: LinkedList[A] = Empty

  def apply[A](as: A*): LinkedList[A] = {
    as.foldRight(empty[A])((a, l) => l prepend a)
  }
}

/** An empty node marking the end of the list. */
case object Empty extends LinkedList[Nothing] {
  override def head: Nothing = ???

  override def isEmpty: Boolean = true

  override def tail: LinkedList[Nothing] = ???
}

case class Node[+A](head: A, tail: LinkedList[A]) extends LinkedList[A] {
  override def isEmpty: Boolean = false
}
