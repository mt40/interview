package leetcode

import common.SolutionSuite

class FruitIntoBasketsSuite extends SolutionSuite {
  private def testCase(tree: Array[Int], expect: Int) = {
    test(s"Pick fruits from ${tree.prettyString}") {
      FruitIntoBaskets.totalFruit(tree) shouldEqual expect
    }
  }

  testCase(Array.empty, 0)
  testCase(Array(1), 1)
  testCase(Array(1, 2, 2), 3)
  testCase(Array(1, 2, 2, 1), 4)
  testCase(Array(1, 2, 3, 2, 2), 4)
  testCase(Array(1, 2, 3, 2, 2, 5, 5, 2), 5)
  testCase(Array(3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4), 5)
}
