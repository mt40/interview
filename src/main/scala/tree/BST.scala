package tree

import scala.annotation.tailrec

/**
  * Implementation of Binary Search Tree.
  *
  * @tparam A type of values in this tree. We define this to be
  *           co-variant so that `Leaf` can be a child of all
  *           trees
  *
  * @see https://en.wikipedia.org/wiki/Binary_search_tree
  */
abstract class BST[+A] {
  def value: A

  def left: BST[A]

  def right: BST[A]

  def height: Int

  /**
    * Returns a new tree with the given value inserted.
    *
    * Time: O(logn)
    * Space: O(logn) because we have to create a new branch
    *
    * We cannot simply define this method as `insert(a: A): BST[A]`
    * because that would violate the variance. If that definition is
    * possible, we would have this situation:
    * {{{
    *   trait Animal
    *   class Cat extends Animal
    *   class Dog extends Animal
    *
    *   val cats: BST[Cat] = ???
    *   val animals: BST[Animal] = cats // ok because Cat <: Animal
    *   animals.insert(dog) // what!?
    * }}}
    * So to avoid this situation, if we define covariance `+A`,
    * we cannot have `A` as parameters. We must force the parameter
    * to be `A` or a parent of `A`.
    *
    * In general, co-variance `+T` cannot be parameter but can be return
    * type. Contra-variance `-T` can be parameter but cannot be return
    * type.
    */
  def insert[B >: A](b: B)(implicit ob: Ordering[B]): BST[B] = {
    this match {
      case Leaf => Branch(b)
      case Branch(v, l, r, _) =>
        val inserted = {
          if (ob.lteq(b, v)) Branch(v, l.insert(b), r)
          else Branch(v, l, r.insert(b))
        }
        inserted.balanced
    }
  }

  /**
    * Returns true if `x` is in this tree.
    *
    * Time: O(logn)
    */
  def contains[B >: A](x: B)(implicit ob: Ordering[B]): Boolean = {
    @tailrec
    def loop(t: BST[A]): Boolean = {
      t match {
        case Leaf => false
        case Branch(v, l, r, _) =>
          if (ob.equiv(v, x)) true
          else if (ob.lt(x, v)) loop(l)
          else loop(r)
      }
    }

    loop(this)
  }

  /**
    * Returns the number of elements in this tree.
    *
    * Time: O(n)
    */
  def size: Int = {
    def loop(t: BST[A]): Int = {
      t match {
        case Branch(_, l, r, _) => 1 + loop(l) + loop(r)
        case Leaf               => 0
      }
    }

    loop(this)
  }

  /** Returns a new balanced tree. */
  protected final def balanced: BST[A] = {
    val balance = this.left.height - this.right.height
    if (balance <= -2) { // left side is "heavier"
      Branch(value, left, right.rotatedRight).rotatedLeft
    }
    else if (balance >= 2) { // right side is "heavier"
      Branch(value, left.rotatedLeft, right).rotatedRight
    }
    else this
  }

  protected final def rotatedLeft: BST[A] = {
    this match {
      case Leaf                  => Leaf
      case Branch(_, _, Leaf, _) => this
      case Branch(v, l, r, _) =>
        val newLeft = Branch(v, l, r.left)
        Branch(r.value, newLeft, r.right)
    }
  }

  protected final def rotatedRight: BST[A] = {
    this match {
      case Leaf                  => Leaf
      case Branch(_, Leaf, _, _) => this
      case Branch(v, l, r, _) =>
        val newRight = Branch(v, l.right, r)
        Branch(l.value, l.left, newRight)
    }
  }

  /** Applies `f` to all nodes in this tree in in-order. */
  def traverse(f: BST[A] => Unit): Unit = {
    def loop(t: BST[A]): Unit = {
      t match {
        case Leaf =>
        case b @ Branch(_, l, r, _) =>
          loop(l)
          f(b)
          loop(r)
      }
    }

    loop(this)
  }

  /** Returns a sorted list containing all values. */
  def toList: List[A] = {
    def loop(t: BST[A], rs: List[A]): List[A] = {
      t match {
        case Leaf               => rs
        case Branch(v, l, r, _) => loop(l, v +: loop(r, rs))
      }
    }

    loop(this, Nil)
  }
}

object BST {

  def empty[A]: BST[A] = Leaf

  def apply[A : Ordering](as: A*): BST[A] = {
    var tree = empty[A]
    as.foreach(a => tree = tree.insert(a))
    tree
  }
}

case object Leaf extends BST[Nothing] {
  override def value: Nothing = ???

  override def left: BST[Nothing] = ???

  override def right: BST[Nothing] = ???

  override def height: Int = 0
}

case class Branch[A](value: A, left: BST[A], right: BST[A], height: Int) extends BST[A] {

  /**
    * Returns the node in the tree that is the Lowest Common Ancestor
    * of the 2 given sub-tree.
    *
    * Time: O(logn)
    *
    * @note will return wrong result if the given parameters are not sub-tree
    *       of this tree
    */
  @tailrec
  final def lca(a: Branch[A], b: Branch[A])(implicit oa: Ordering[A]): Branch[A] = {
    if (oa.lt(b.value, a.value)) {
      lca(b, a)
    }
    else {
      if (oa.lteq(a.value, this.value) && oa.lteq(this.value, b.value)) {
        this
      }
      else if (oa.lt(b.value, this.value)) {
        this.left match {
          case Leaf         => ???
          case l: Branch[A] => l.lca(a, b)
        }
      }
      else {
        this.right match {
          case Leaf         => ???
          case r: Branch[A] => r.lca(a, b)
        }
      }
    }
  }
}

object Branch {

  def apply[A](value: A, left: BST[A], right: BST[A]): Branch[A] = {
    val height = 1 + math.max(left.height, right.height)
    Branch(value, left, right, height)
  }

  def apply[A](value: A): Branch[A] = Branch(value, Leaf, Leaf, height = 1)
}
