package leetcode

/**
  * Idea: we print the outer layer of the matrix in clock-wise order
  * and repeat that with the inner matrix.
  *
  * Complexity: O(n) where n is number of elements
  *
  * @see https://leetcode.com/problems/spiral-matrix
  */
object SpiralMatrix {

  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
    def loop(x: Int, y: Int, cols: Int, rows: Int): Seq[Int] = {
      if (cols <= 0 || rows <= 0) {
        List.empty
      }
      else {
        val rightMost = x + cols - 1
        val bottomMost = y + rows - 1

        val top = (x until x + cols).map(matrix(x)(_))
        val bot =
          if (rows > 1) (x until x + cols).map(matrix(bottomMost)(_)).reverse
          else Seq.empty

        val left =
          if (cols > 1) (y + 1 until bottomMost).map(matrix(_)(y)).reverse
          else Seq.empty
        val right = (y + 1 until bottomMost).map(matrix(_)(rightMost))

        top ++ right ++ bot ++ left ++ loop(x + 1, y + 1, cols - 2, rows - 2)
      }
    }

    if (matrix.isEmpty) List.empty
    else loop(0, 0, matrix.head.length, matrix.length).toList
  }
}
