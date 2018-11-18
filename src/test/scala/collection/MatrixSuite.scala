package collection

import common.SolutionSuite

class MatrixSuite extends SolutionSuite {
  test("'toString'") {
    Matrix(2, 3, 0).toString shouldEqual "0 0 0\n0 0 0"
    Matrix(1, 3, Seq(6, 1, 9)).toString shouldEqual "6 1 9"
  }

  test("'times'") {
    def check(a: Matrix[Int], b: Matrix[Int], expect: Matrix[Int]): Unit = {
      a.times(b) shouldEqual expect
    }

    check(
      Matrix(1, 1, Seq(10)),
      Matrix(1, 2, Seq(3, 4)),
      expect = Matrix(1, 2, Seq(30, 40))
    )

    check(
      Matrix(2, 1, Seq(1, 2)),
      Matrix(1, 2, Seq(3, 4)),
      expect = Matrix(2, 2, Seq(3, 4, 6, 8))
    )

    check(
      Matrix(2, 3, Seq(1, 2, 3, 4, 5, 6)),
      Matrix(3, 2, Seq(7, 8, 9, 10, 11, 12)),
      expect = Matrix(2, 2, Seq(58, 64, 139, 154))
    )
  }
}
