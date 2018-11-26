package misc

import common.SolutionSuite

class IsPalindromeSuite extends SolutionSuite {
  IsPalindrome("a") shouldBe true
  IsPalindrome("ab") shouldBe false
  IsPalindrome("aba") shouldBe true
  IsPalindrome("abba") shouldBe true
  IsPalindrome("abcba") shouldBe true
  IsPalindrome("abccba") shouldBe true
}
