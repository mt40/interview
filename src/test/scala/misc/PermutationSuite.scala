package misc

import common.SolutionSuite

class PermutationSuite extends SolutionSuite {
  private def testCase(n: Int, k: Int, expect: Long) = {
    test(s"Test input $n & $k") {
      Permutation(n, k) shouldEqual expect
    }
  }

  testCase(n = 1, k = 1, expect = 1)
  testCase(n = 4, k = 2, expect = 12)
}
