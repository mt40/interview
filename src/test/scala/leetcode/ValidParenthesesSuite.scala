package leetcode

import common.SolutionSuite

class ValidParenthesesSuite extends SolutionSuite {

  def testCase(s: String, expect: Boolean): Unit = {
    test(s"Check $s") {
      ValidParentheses.isValid(s) shouldEqual expect
    }
  }

  testCase("", true)
  testCase("[()]", true)
  testCase("[()]{}", true)
  testCase("[](){}", true)
  testCase("([)]", false)
  testCase("([(]))", false)
  testCase("(]", false)
  testCase("{{}", false)
  testCase("{}[", false)
  testCase("))", false)
}
