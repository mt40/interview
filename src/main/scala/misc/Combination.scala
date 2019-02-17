package misc

/**
  * Returns the math combination of n & k
  * (a selection of k items from a collection of size n)
  *
  * @see https://en.wikipedia.org/wiki/Combination
  */
object Combination {

  /**
    * Product formula
    * Complexity: O(k)
    */
  def apply(n: Int, k: Int): Long = {
    (1 to k).toStream.map(n - _ + 1).product / FactorialStream()(k)
  }

  /**
    * Recursive formula (aka Pascal triangle formula)
    * Complexity: O(k)
    */
  def applyRecursive(n: Int, k: Int): Long = {
    (n, k) match {
      case (_, 0) | (`n`, `n`) => 1
      case _                   => applyRecursive(n - 1, k - 1) + applyRecursive(n - 1, k)
    }
  }

  /**
    * Another recursive formula.
    * Complexity: O(k)
    */
  def applyRecursive2(n: Int, k: Int): Long = {
    (n, k) match {
      case (_, 0) | (`n`, `n`) => 1
      case _                   => n * applyRecursive2(n - 1, k - 1) / k
    }
  }
}
