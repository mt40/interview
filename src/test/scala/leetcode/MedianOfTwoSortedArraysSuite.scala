package leetcode

import common.SolutionSuite

class MedianOfTwoSortedArraysSuite extends SolutionSuite {
  private def testCase(a: Array[Int], b: Array[Int]) = {
    test(s"${a.toSeq} - ${b.toSeq}") {
      import MedianOfTwoSortedArrays._
      val expect = median((a ++ b).sorted)
      findMedianSortedArrays(a, b) shouldEqual expect
    }
  }

  testCase(Array(1, 2), Array(4, 5))
  testCase(Array(1), Array(4))
  testCase(Array(1, 2, 3), Array(4, 5, 6))
  testCase(Array(1, 2, 7, 10), Array(4, 5, 6, 9))
  testCase(Array(4, 5), Array(2, 7, 10))
  testCase(Array(4, 5, 6), Array(1, 2, 7, 10))
  testCase(Array(1, 3), Array(2))
  testCase(Array(1, 3), Array.empty[Int])
  testCase(Array.empty[Int], Array(1, 3))
  testCase(Array(-2, -1), Array(3))
  testCase(Array(3), Array(-2, -1))
  testCase(Array(4), Array(1, 2, 3))
  testCase(Array(-1), Array(1, 2, 3))
  testCase(Array(5, 9, 12), Array(4))
  testCase(Array(5, 9, 12), Array(10))
  testCase(Array(5), Array(1, 2, 3, 4, 6, 7))
  testCase(Array(6, 7, 9, 10), Array(5))
}
