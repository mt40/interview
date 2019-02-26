package leetcode

import common.SolutionSuite

class MultiplyStringsSuite extends SolutionSuite {
  private def testCase(num1: String, num2: String) = {
    test(s"Multiply $num1 and $num2") {
      val expect = (BigInt(num1) * BigInt(num2)).toString()
      MultiplyStrings.multiply(num1, num2) shouldEqual expect
    }
  }

  testCase("0", "1")
  testCase("10", "1")
  testCase("1", "1")
  testCase("0", "0")
  testCase("2", "3")
  testCase("2", "32")
  testCase("123", "456")
  testCase("123", "4560")
  testCase("1230", "456")
  testCase("123", "0")
  testCase("0", "123")
  testCase("123", "1")
}
