package tree

import common.SolutionSuite

class BSTSuite extends SolutionSuite {

  test("balancing") {
    def check(tree: BST[Int], insert: Int, expect: BST[Int]): Unit = {
      tree.insert(insert) shouldEqual expect
      tree.traverse(t => math.abs(t.left.height - t.right.height) should be < 2)
    }

    check(
      Branch(10, Branch(1), Leaf),
      insert = 5,
      expect = Branch(5, Branch(1), Branch(10))
    )

    check(
      Branch(10, Branch(1), Leaf),
      insert = -4,
      expect = Branch(1, Branch(-4), Branch(10))
    )

    check(
      Branch(10, Leaf, Branch(20)),
      insert = 12,
      expect = Branch(12, Branch(10), Branch(20))
    )
  }

  test("'toList'") {
    BST(1, 0).toList shouldEqual List(0, 1)
    BST(10, 5, 9, 1).toList shouldEqual List(1, 5, 9, 10)
    BST(2, 4, 2).toList shouldEqual List(2, 2, 4)
    BST[Int]().toList shouldEqual List.empty[Int]
  }

  test("'contains'") {
    BST(1).contains(1) shouldEqual true
    BST(1).contains(2) shouldEqual false
    BST(10, 5, 9, 1).contains(3) shouldEqual false
    BST(10, 5, 9, 1).contains(20) shouldEqual false
    BST(10, 5, 9, 1).contains(9) shouldEqual true
  }

  test("'size'") {
    BST(1).size shouldEqual 1
    BST(10, 5, 9, 1).size shouldEqual 4
  }

  test("'lca'") {
    def check(tree: Branch[Int], l: Branch[Int], r: Branch[Int], expect: Int): Unit = {
      tree.lca(l, r).value shouldEqual expect
    }

    check(
      Branch(1, Leaf, Branch(2)),
      Branch(1),
      Branch(2),
      expect = 1
    )

    check(
      Branch(5, Leaf, Branch(10, Branch(7), Branch(15, Branch(12), Leaf))),
      Branch(7),
      Branch(12),
      expect = 10
    )
  }

  test("'diameter'") {
    def check(tree: BST[_], expect: Int): Unit = {
      tree.diameter shouldEqual expect
    }

    check(Leaf, expect = 0)
    check(Branch(1), expect = 1)
    check(Branch(1, Branch(-2), Branch(10)), expect = 2)
    check(Branch(1, Branch(-2), Branch(10, Branch(7))), expect = 2)
  }
}
