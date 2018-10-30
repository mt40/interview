import common.SolutionSuite

class BinarySearchSuite extends SolutionSuite {

  private def testCase(a: Array[Int], x: Int, expect: Int): Unit = {
    makeTest { new BinarySearch().run(a, x) shouldEqual expect }
  }

  testCase(Array(1, 2, 3), 2, expect = 1)
  testCase(Array(1, 2, 3, 4), 2, expect = 1)
  testCase(Array(1, 2, 3, 4), 3, expect = 2)
  testCase(Array(1, 2, 3, 4), 4, expect = 3)
  testCase(Array(), 4, expect = 0)
  testCase(Array(1, 2, 10, 20), -5, expect = 0)
  testCase(Array(1, 2, 10, 20), 12, expect = 3)
  testCase(Array(1, 2, 10, 20), 30, expect = 4)

}
