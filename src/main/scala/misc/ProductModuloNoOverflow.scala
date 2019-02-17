package misc

/** Returns the result of a * b % m without overflow from a * b. */
object ProductModuloNoOverflow {
  def apply(a: Int, b: Int, m: Int): Int = {
    ((a % m) * (b % m)) % m
  }
}
