package misc

import common.SolutionSuite

class FactorialStreamSuite extends SolutionSuite {
  test("First 10 factorials") {
    val expect = Seq(1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880)
    FactorialStream().take(10) shouldEqual expect
  }
}
