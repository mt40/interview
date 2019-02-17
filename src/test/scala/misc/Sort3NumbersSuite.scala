package misc

import common.SolutionSuite

class Sort3NumbersSuite extends SolutionSuite {
  test("sort random 3 numbers") {
    forAll { (a: Int, b: Int, c: Int) =>
      val expect = Seq(a, b, c).sorted match {
        case Seq(x, y, z) => (x, y, z)
      }
      Sort3Numbers(a, b, c) shouldEqual expect
    }
  }
}
