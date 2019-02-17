package misc

import common.SolutionSuite

class PermutationsOfStringSuite extends SolutionSuite {
  private def testCase(s: String) = {
    test(s"Permutations of string '$s'") {
      PermutationsOfString(s) shouldEqual s.permutations.toStream
    }
  }

  testCase("")
  testCase("a")
  testCase("abcde")
}
