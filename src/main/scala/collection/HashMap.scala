package collection

import collection.HashMap._

import scala.annotation.tailrec

class HashMap[K, V] private (val entries: Vector[Vector[Entry[K, V]]]) {

  /**
    * Returns a new map with the given entry added.
    * Time: O(1)
    */
  @tailrec
  final def add(key: K, value: V): HashMap[K, V] = {
    val idx = indexFor(key)
    if (entries.isEmpty) init.add(key, value)
    else {
      // if key already exist, replace the value
      // if not, add a new entry with that key to the chain
      val chain = entries(idx)
      chain.indexWhere(_.key == key) match {
        case -1 =>
          val entry = Entry(key, value)
          new HashMap(entries.updated(idx, entry +: chain))
        case i =>
          val replaced = chain(i).copy(value = value)
          new HashMap(entries.updated(idx, chain.updated(i, replaced)))
      }
    }
  }

  private def init: HashMap[K, V] = {
    new HashMap(Vector.fill(initialCapacity)(Vector.empty))
  }

  /** Returns the index of this key in the internal entry vector. */
  private def indexFor(key: K): Int = {
    key.hashCode() & entries.length
  }

  /**
    * Returns a new map without the entry of the given key.
    * Time: O(1)
    */
  def remove(key: K): HashMap[K, V] = {
    val idx = indexFor(key)
    // The removal here is a bit in-efficient since `filter` will go through
    // all elements of the chain. That is not needed because we know we only need
    // to remove exactly that 1 element.
    // Another faster way to remove is to just mark the element as "removed"
    // without actually removing it.
    val updated = entries.updated(idx, entries(idx).filter(_.key != key))
    new HashMap(updated)
  }

  /**
    * Returns the value of the given key or None if there is no such value.
    * Time: O(1)
    */
  def get(key: K): Option[V] = {
    val idx = indexFor(key)
    entries(idx).find(_.key == key).map(_.value)
  }

  def toSeq: Seq[(K, V)] = entries.flatMap(_.map(_.tuple))
}

object HashMap {
  case class Entry[K, V](key: K, value: V) {
    def tuple: (K, V) = (key, value)
  }

  /**
    * Here for simplicity, we always have a fixed capacity. But in real world
    * implementation, we will need to grow our hash map capacity to maintain
    * the constant complexity.
    */
  private final val initialCapacity: Int = 16

  def empty[K, V]: HashMap[K, V] = new HashMap(Vector.empty)

  def apply[K, V](pairs: (K, V)*): HashMap[K, V] = {
    pairs.foldLeft(empty[K, V])((map, p) => map.add(p._1, p._2))
  }
}
