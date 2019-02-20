package misc

/**
  * Given base `b` and exponent `e`, computes `b^e` (`^` means power, not XOR)
  * We can compute this naively by multiplying `e` `b` with each other.
  * But we can do better by using this properties:
  * {{{
  *   b^e = (b^2) ^ (e / 2) // if e is even
  *   b^e = b * (b^2) ^ ((e - 1) / 2) // if e is odd
  * }}}
  *
  * Complexity: O(loge)
  */
object ExponentialBySquaring {

  def recursive(base: Double, exp: Int): Double = {
    exp match {
      case 0 => 1
      case _ =>
        val half = recursive(base * base, exp / 2)
        if (exp % 2 == 0) half
        else {
          if (exp < 0) half / base
          else half * base
        }
    }
  }

  def iterative(base: Double, exp: Int): Double = {
    var (b, e, rs) = (base, exp, 1.0)
    while (e != 0) {
      if (e % 2 != 0) {
        if (e < 0) rs /= b else rs *= b
      }
      e = e / 2
      b *= b
    }
    rs
  }
}
