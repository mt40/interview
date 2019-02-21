package leetcode

import common.SolutionSuite

class WordBreakSuite extends SolutionSuite {
  private def testCase(s: String, dict: List[String], expect: Boolean) = {
    test(s"Word break '$s' with dict {${dict.mkString(", ")}}") {
      WordBreak.wordBreak(s, dict) shouldEqual expect
    }
  }

  testCase("a", List("a"), expect = true)
  testCase("b", List("a"), expect = false)
  testCase("aba", List("a"), expect = false)
  testCase("aba", List("a", "ab"), expect = true)
  testCase("aba", List("a", "ba"), expect = true)
  testCase("aba", List("a", "ab", "ba", "b"), expect = true)
  testCase("ababf", List("ab", "f"), expect = true)
  testCase("ababf", List("ab", "aba", "a", "f"), expect = true)
  testCase("abaabf", List("aba", "a", "f"), expect = false)
  testCase("applepenapple", List("apple", "pen"), expect = true)
  testCase("catsandog", List("cats", "dog", "sand", "and", "cat"), expect = false)
}
