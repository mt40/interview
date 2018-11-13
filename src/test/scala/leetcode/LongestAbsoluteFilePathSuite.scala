package leetcode

import common.SolutionSuite

class LongestAbsoluteFilePathSuite extends SolutionSuite {

  def testCase(input: String, expect: Int): Unit = {
    test(s"$input") {
      LongestAbsoluteFilePath.lengthLongestPath(input) shouldEqual expect
    }
  }

  testCase(
    input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext",
    expect = 20
  )

  testCase(
    input =
      "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext",
    expect = 32
  )

  testCase(
    input = "a\n\ta\n\t\tf.t\n\tbbb.t",
    expect = 7
  )

  testCase(
    input = "a\n\ta\n\t\tf.t\n\tbbbb.t",
    expect = 8
  )

  testCase(
    input = "a\n\ta\n\t\ta\n\ta",
    expect = 0
  )

  testCase(
    input = "a\n\ta\n\t\tf.t\n\ta\n\ta\n\t\tff.t",
    expect = 8
  )

  testCase(
    input = "f.t",
    expect = 3
  )
}
