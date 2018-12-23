package leetcode

import common.SolutionSuite

class ContainerWithMostWaterSuite extends SolutionSuite {
  private def testCase(heights: Array[Int]) = {
    test(heights.mkString(", ")) {
      val expect = {
        val areas = for {
          (l, i) <- heights.zipWithIndex
          (r, j) <- heights.zipWithIndex if j > i
        } yield math.min(l, r) * (j - i)
        areas.max
      }
      ContainerWithMostWater.maxArea(heights) shouldEqual expect
    }
  }

  testCase(Array(1, 3))
  testCase(Array(3, 1))
  testCase(Array(3, 2, 2))
  testCase(Array(3, 1, 1, 3))
  testCase(Array(1, 0, 0, 2, 0, 5))
  testCase(Array(2, 1, 4, 0, 0, 5))
  testCase(Array(2, 1, 4, 0, 0, 5, 0, 2))
  testCase(Array(1, 8, 6, 2, 5, 4, 8, 3, 7))
}
