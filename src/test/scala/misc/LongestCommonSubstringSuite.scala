package misc

import common.SolutionSuite

class LongestCommonSubstringSuite extends SolutionSuite {
  private def testCase(a: String, b: String, expect: String) = {
    test(s"$a - $b") {
      LongestCommonSubstring(a, b) shouldEqual expect
    }
  }

  testCase("a", "b", expect = "")
  testCase("abc", "bef", expect = "b")
  testCase("ebcebcd", "abcdef", expect = "bcd")
}
