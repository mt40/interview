package misc

/**
  * Returns the partial permutation of n
  * ("partial" means each permutation doesn't contain all elements of n).
  *
  * "Full" permutation is computed by: n!
  *
  * @see https://en.wikipedia.org/wiki/Permutation#k-permutations_of_n
  */
object Permutation {

  def apply(n: Int, k: Int): Long = {
    FactorialStream()(n) / FactorialStream()(n - k)
  }
}
