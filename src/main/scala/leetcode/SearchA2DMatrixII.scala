package leetcode

import scala.annotation.tailrec

/**
  * Idea:
  * - start from the bottom left cell
  * - if cell is target, true
  * - if cell < target, go right 1 column
  * - if cell > target, go up 1 row
  *
  * Complexity: O(n + m) where n and m is the number of rows and columns.
  *
  * @see https://leetcode.com/problems/search-a-2d-matrix-ii/
  */
object SearchA2DMatrixII {

  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    @tailrec
    def loop(row: Int, col: Int): Boolean = {
      if (row < 0 || col >= matrix.head.length) false
      else {
        val cur = matrix(row)(col)
        if (cur == target) true
        else if (cur < target) loop(row, col + 1)
        else loop(row - 1, col)
      }
    }

    loop(matrix.length - 1, 0)
  }
}
