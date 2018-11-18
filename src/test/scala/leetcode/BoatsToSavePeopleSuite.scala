package leetcode

import common.SolutionSuite

class BoatsToSavePeopleSuite extends SolutionSuite {

  def testCase(people: Array[Int], limit: Int, expect: Int): Unit = {
    test(s"${people.toSeq} - $limit") {
      BoatsToSavePeople.numRescueBoats(people, limit) shouldEqual expect
    }
  }

  testCase(Array(1, 2), limit = 3, expect = 1)
  testCase(Array(1, 2), limit = 2, expect = 2)
  testCase(Array(1, 2), limit = 10, expect = 1)
  testCase(Array(2, 2, 2), limit = 2, expect = 3)
  testCase(Array(2, 2, 2), limit = 3, expect = 3)
  testCase(Array(2, 2, 2), limit = 4, expect = 2)
  testCase(Array(3, 2, 2, 1), limit = 3, expect = 3)
  testCase(Array(3, 5, 3, 4), limit = 5, expect = 4)
  testCase(Array(2, 3, 4, 1, 1), limit = 3, expect = 4)
}
