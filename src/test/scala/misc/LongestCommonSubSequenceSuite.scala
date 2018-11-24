package misc

import common.SolutionSuite

class LongestCommonSubSequenceSuite extends SolutionSuite {
  private def testCase(a: String, b: String, expect: String) = {
    test(s"$a - $b") {
      LongestCommonSubSequence(a, b) shouldEqual expect
    }
  }

  testCase("a", "b", expect = "")
  testCase("a", "a", expect = "a")
  testCase("abc", "eac", expect = "ac")
  testCase("abcd", "bace", expect = "bc")
  testCase("abcd", "bacd", expect = "bcd")
}
