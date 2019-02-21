package leetcode

// scalastyle:off null
object BinarySearchTreeIterator {

  class TreeNode(val value: Int) {
    var left: TreeNode = null
    var right: TreeNode = null
  }

  class BSTIterator(root: TreeNode) {

    private var cur: TreeNode = leftMost(root)

    /** @return the next smallest number */
    def next(): Int = {
      // rs is cur, now we need to move cur to prepare for the next query
      // if cur has right, cur = leftMost(cur.right)
      // else we need to search for a lowest node that has cur in the left sub-tree
      // cur = that node
      val rs = cur.value
      moveCur()
      rs
    }

    private def moveCur(): Unit = {
      if (cur.right != null) cur = leftMost(cur.right)
      else cur = lowestRightParent(cur)
    }

    private def leftMost(x: TreeNode): TreeNode = {
      if (x.left != null) leftMost(x.left) else x
    }

    private def lowestRightParent(x: TreeNode): TreeNode = {
      def loop(i: TreeNode, p: TreeNode): TreeNode = {
        if (i == x) p
        else if (x.value <= i.value) loop(i.left, i)
        else loop(i.right, p)
      }

      loop(root, null)
    }

    /** @return whether we have a next smallest number */
    def hasNext(): Boolean = cur != null
  }
}
