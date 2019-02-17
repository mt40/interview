package misc

import common.SolutionSuite

class PascalTriangleSuite extends SolutionSuite {
  private def testCase(height: Int, expect: String) = {
    test(s"height = $height") {
      println(PascalTriangle(height))
      PascalTriangle(height) shouldEqual expect
    }
  }

  testCase(height = 0, expect = "")

  testCase(height = 1, expect = "1")

  testCase(
    height = 2,
    expect = {
      """ 1
        |1 1""".stripMargin
    }
  )

  testCase(
    height = 5,
    expect = {
      """    1
        |   1 1
        |  1 2 1
        | 1 3 3 1
        |1 4 6 4 1""".stripMargin
    }
  )
}
