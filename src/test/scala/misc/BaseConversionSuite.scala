package misc

import common.SolutionSuite

class BaseConversionSuite extends SolutionSuite {

  test("'toBinary'") {
    def check(i: Int) = {
      BaseConversion.toBinary(i) shouldEqual i.toBinaryString
    }

    check(0)
    check(10)
    check(5)
    check(25)
    check(-1)
    check(-12)
  }

}
