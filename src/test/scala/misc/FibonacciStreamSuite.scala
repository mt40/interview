package misc

import common.SolutionSuite

class FibonacciStreamSuite extends SolutionSuite {
  test("Fibonacci number 0th to 9th") {
    val expect = Seq(0, 1, 1, 2, 3, 5, 8, 13, 21)
    FibonacciStream().take(9) shouldEqual expect
  }
}
