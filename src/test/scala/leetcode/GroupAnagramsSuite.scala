package leetcode

import common.SolutionSuite

class GroupAnagramsSuite extends SolutionSuite {
  private def testCase(strings: Array[String], expect: List[List[String]]) = {
    test(s"Group anagrams in ${strings.prettyString}") {
      val rs = GroupAnagrams.groupAnagrams(strings)
      rs.zip(expect).foreach {
        case (r, e) => r should contain theSameElementsAs e
      }
    }
  }

  testCase(
    Array("eat", "tea", "tan", "ate", "nat", "bat"),
    List(
      List("ate", "eat", "tea"),
      List("nat", "tan"),
      List("bat")
    )
  )
}
