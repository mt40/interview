package misc

import common.SolutionSuite

class PermutationsOfNumberSuite extends SolutionSuite {
  private def testCase(n: Int) = {
    test(s"Permutations of [0..$n]") {
      val expect = (0 to n).permutations.toStream
      PermutationsOfNumber(n) shouldEqual expect
    }
  }

  testCase(0)
  testCase(1)
  testCase(5)
}
