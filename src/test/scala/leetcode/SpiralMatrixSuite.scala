package leetcode

import common.SolutionSuite

class SpiralMatrixSuite extends SolutionSuite {
  private def testCase(mat: Array[Array[Int]], expect: List[Int]) = {
    val str = mat.map(_.mkString(", ")).mkString("; ")
    test(s"Spiral traversal of $str") {
      SpiralMatrix.spiralOrder(mat) shouldEqual expect
    }
  }

  testCase(Array.empty, List.empty)
  testCase(Array(Array(1)), List(1))
  testCase(Array(Array(1, 3)), List(1, 3))

  testCase(
    Array(
      Array(1),
      Array(2)
    ),
    List(1, 2)
  )

  testCase(
    Array(
      Array(1),
      Array(2),
      Array(3)
    ),
    List(1, 2, 3)
  )

  testCase(
    Array(
      Array(1, 2),
      Array(4, 3)
    ),
    List(1, 2, 3, 4)
  )

  testCase(
    Array(
      Array(1, 2),
      Array(6, 3),
      Array(5, 4)
    ),
    List(1, 2, 3, 4, 5, 6)
  )

  testCase(
    Array(
      Array(1, 2, 3),
      Array(8, 9, 4),
      Array(7, 6, 5)
    ),
    List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  )
}
