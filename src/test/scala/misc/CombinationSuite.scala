package misc

import common.SolutionSuite

class CombinationSuite extends SolutionSuite {
  private def testCase(n: Int, k: Int, expect: Long) = {
    test(s"Combination of $n & $k") {
      Combination(n, k) shouldEqual expect
      Combination.applyRecursive(n, k) shouldEqual expect
    }
  }

  testCase(n = 1, k = 1, expect = 1)
  testCase(n = 2, k = 2, expect = 1)
  testCase(n = 2, k = 1, expect = 2)
  testCase(n = 3, k = 2, expect = 3)
  testCase(n = 10, k = 3, expect = 120)
  testCase(n = 52, k = 5, expect = 2598960)
}
