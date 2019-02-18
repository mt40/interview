package leetcode

import common.SolutionSuite

class GenerateParenthesesSuite extends SolutionSuite {

  def testCase(n: Int, expect: List[String]): Unit = {
    test(s"Generate $n pairs of parenthesis") {
      GenerateParentheses.generateParenthesis(n) should contain theSameElementsAs expect
    }
  }

  testCase(0, List.empty)
  testCase(1, List("()"))
  testCase(2, List("(())", "()()"))
  testCase(3, List("((()))", "(()())", "(())()", "()(())", "()()()"))
}
