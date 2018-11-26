package misc

import common.SolutionSuite

class LongestPalindromicSubstringSuite extends SolutionSuite {
  private def testCase(s: String, expect: String) = {
    test(s) {
      LongestPalindromicSubstring(s) shouldEqual expect
    }
  }

  testCase("babad", expect = "bab")
  testCase("cbbd", expect = "bb")
  testCase("baccad", expect = "acca")
  testCase("ab", expect = "a")
  testCase("aadacbcae", expect = "acbca")
}
