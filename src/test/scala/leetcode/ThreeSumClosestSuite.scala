package leetcode

import common.SolutionSuite

class ThreeSumClosestSuite extends SolutionSuite {
  private def testCase(nums: Array[Int], target: Int) = {
    test(s"${nums.toList} - $target") {
      val expect = {
        val triplets = for {
          i <- nums.indices
          j <- nums.indices if j > i
          k <- nums.indices if k > j
        } yield nums(i) + nums(j) + nums(k)
        triplets.minBy(sum => math.abs(sum - target))
      }

      ThreeSumClosest.threeSumClosest(nums, target) shouldEqual expect
    }
  }

  testCase(Array(0, 0, 0), 1)
  testCase(Array(0, 0, 0, 1), 1)
  testCase(Array(0, 0, 0, 2, 1), 1)
  testCase(Array(5, 4, 3, 2, 1), 1)
  testCase(Array(-5, 4, 3, 2, 1), 1)
  testCase(Array(-1, 2, 1, -4), 1)
  testCase(Array(1, 2, 5, 10, 11), 12)
}
