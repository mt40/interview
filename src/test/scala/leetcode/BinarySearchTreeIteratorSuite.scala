package leetcode

import common.SolutionSuite
import leetcode.BinarySearchTreeIterator.TreeNode

class BinarySearchTreeIteratorSuite extends SolutionSuite {

  object TreeNode {

    def apply(v: Int, left: TreeNode = null, right: TreeNode = null): TreeNode = {
      val n = new TreeNode(v)
      n.left = left
      n.right = right
      n
    }
  }

  test("binary search tree iterator") {
    val root = TreeNode(
      10,
      TreeNode(
        5,
        right = TreeNode(
          8,
          TreeNode(6),
          TreeNode(9)
        )
      ),
      TreeNode(
        12,
        right = TreeNode(20)
      )
    )

    val it = new BinarySearchTreeIterator.BSTIterator(root)
    it.hasNext() shouldEqual true
    it.next() shouldEqual 5
    it.next() shouldEqual 6
    it.next() shouldEqual 8
    it.hasNext() shouldEqual true
    it.next() shouldEqual 9
    it.next() shouldEqual 10
    it.next() shouldEqual 12
    it.hasNext() shouldEqual true
    it.next() shouldEqual 20
    it.hasNext() shouldEqual false
  }
}
