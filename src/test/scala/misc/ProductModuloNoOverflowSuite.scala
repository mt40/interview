package misc

import common.SolutionSuite

class ProductModuloNoOverflowSuite extends SolutionSuite {
  private def testCase(a: Int, b: Int, m: Int) = {
    test(s"Compute $a * $b % $m") {
      ProductModuloNoOverflow(a, b, m) shouldEqual (a * 1L * b % m)
    }
  }

  testCase(a = 1000 * 1000 * 1000, b = 200, m = 123)
}
