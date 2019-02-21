package leetcode

import common.SolutionSuite

class SearchA2DMatrixIISuite extends SolutionSuite {
  private def testCase(matrix: Array[Array[Int]], target: Int) = {
    test(s"Search $target in $matrix") {
      val expect = matrix.map(_.find(_ == target)).exists(_.isDefined)
      SearchA2DMatrixII.searchMatrix(matrix, target) shouldEqual expect
    }
  }

  testCase(Array.empty, 5)

  testCase(
    Array(
      Array(0, 1),
      Array(4, 5)
    ),
    target = 3
  )

  testCase(
    Array(
      Array(0, 1),
      Array(4, 5)
    ),
    target = 1
  )

  testCase(
    Array(
      Array(0, 1),
      Array(4, 5)
    ),
    target = 5
  )

  testCase(
    Array(
      Array(0, 1),
      Array(4, 5)
    ),
    target = 10
  )

  testCase(
    Array(
      Array(0, 1, 6),
      Array(4, 7, 7)
    ),
    target = 7
  )

  testCase(
    Array(
      Array(0, 1, 6),
      Array(4, 7, 7)
    ),
    target = 5
  )
}
