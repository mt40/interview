package tree

import common.SolutionSuite

class BITSuite extends SolutionSuite {
  test("'build'") {
    BIT(1, 2).toSeq shouldEqual Seq(0, 1, 3)
    BIT(1, 0, 2, 1).toSeq shouldEqual Seq(0, 1, 1, 2, 4)
  }

  test("'sum'") {
    val tree = BIT(1, 0, 2, 1, 1, 3, 0, 4, 2)
    tree.sum(3) shouldEqual 4
    tree.sum(0) shouldEqual 1
    tree.sum(8) shouldEqual 14
    tree.sum(3, 5) shouldEqual 5
    tree.sum(7, 7) shouldEqual 4
  }
}
