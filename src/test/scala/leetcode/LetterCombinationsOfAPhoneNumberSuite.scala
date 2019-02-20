package leetcode

import common.SolutionSuite

class LetterCombinationsOfAPhoneNumberSuite extends SolutionSuite {
  private def testCase(digits: String, expect: List[String]) = {
    test(s"Phone letter combination of '$digits'") {
      LetterCombinationsOfAPhoneNumber.letterCombinations(digits) shouldEqual expect
    }
  }

  testCase("", List.empty)
  testCase("2", List("a", "b", "c"))
  testCase("9", List("w", "x", "y", "z"))
  testCase("23", List("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))
}
