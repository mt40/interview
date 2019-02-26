package leetcode

import common.SolutionSuite

class QueueReconstructionByHeightSuite extends SolutionSuite {
  private def testCase(people: Array[Array[Int]], expect: Array[Array[Int]]) = {
    test(s"Reconstruct queue by: $people") {
      QueueReconstructionByHeight.reconstructQueue(people) shouldEqual expect
    }
  }

  private implicit def seqToArray(s: Seq[(Int, Int)]): Array[Array[Int]] = {
    s.map(t => Array(t._1, t._2)).toArray
  }

  testCase(Array.empty, Array.empty)
  testCase(Seq(1 -> 0), Seq(1 -> 0))

  testCase(
    Seq(7 -> 0, 4 -> 0, 5 -> 0),
    Seq(4 -> 0, 5 -> 0, 7 -> 0)
  )

  testCase(
    Seq(7 -> 0, 4 -> 2, 7 -> 1),
    Seq(7 -> 0, 7 -> 1, 4 -> 2)
  )
}
