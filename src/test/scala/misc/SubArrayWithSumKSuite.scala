package misc

import common.SolutionSuite

class SubArrayWithSumKSuite extends SolutionSuite {
  private def testCase(nums: Seq[Int], k: Int) = {
    test(s"$nums - $k") {
      val subArrays = nums.inits.flatMap(_.tails).filter(_.nonEmpty)
      val expect = subArrays.count(_.sum == k)
      SubArrayWithSumK(nums, k) shouldEqual expect
    }
  }

  testCase(Seq(1, 2, 3), k = 3)
  testCase(Seq(1, 2, 3), k = 2)
  testCase(Seq(1, 2, 3), k = 0)
  testCase(Seq(1, 0, 1, 1), k = 2)
  testCase(Seq(0, 0), k = 0)
  testCase(Seq(1), k = 1)
}
