package misc

/**
  * Returns the least common multiple (LCM) of 2 numbers.
  *
  * Idea:
  * - LCM contains the union of all prime factors in both numbers.
  * For example:
  *   + a = 2 * 2 * 7 * 11
  *   + b = 2 * 2 * 3 * 5
  *   + union = 2, 2, 3, 5, 7, 11
  *   + LCM = 2 * 2 * 3, * 5 * 7 * 11
  *
  * Complexity: equals to that of GCD
  */
object LCM {
  def apply(a: Int, b: Int): Int = {
    a * b / GCD(a, b)
  }
}
