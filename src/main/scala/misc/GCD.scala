package misc

/**
  * Returns the greatest common divisor of 2 numbers.
  *
  * Idea:
  * - Let say the 2 given numbers a & b can be factorized as:
  *   + a = 2 * 3 * X
  *   + b = 2 * 3 * Y
  *   (where Y > X)
  * - Then if we assign a = b % a, in the next iteration we will have
  * a = 2 * 3 * (Y - X) and b = 2 * 3 * X. So eventually, we can reduce
  * a to only 2 * 3, that is when b % a = 0.
  *
  * @see https://en.wikipedia.org/wiki/Greatest_common_divisor
  *      https://en.wikipedia.org/wiki/Euclidean_algorithm
  */
object GCD {

  def apply(a: Int, b: Int): Int = {
    if (a == 0) b
    else apply(b % a, a)
  }
}
