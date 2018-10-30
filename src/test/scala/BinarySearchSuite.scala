import common.SolutionSuite

class BinarySearchSuite extends SolutionSuite {

  private def testCase(a: Array[Int], x: Int, expect: Int): Unit = {
    makeTest { new BinarySearch().run(a, x) shouldEqual expect }
  }

  testCase(Array(1, 2, 3), 2, expect = 1)

}
