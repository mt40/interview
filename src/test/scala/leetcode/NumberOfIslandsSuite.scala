package leetcode

import common.SolutionSuite

class NumberOfIslandsSuite extends SolutionSuite {
  private def testCase(grid: Array[Array[Char]], expect: Int) = {
    val str = grid.map(r => s"[${r.mkString(", ")}]").mkString(", ")
    test(s"Count islands of $str") {
      NumberOfIslands.numIslands(grid) shouldEqual expect
    }
  }

  testCase(Array.empty, 0)

  testCase(
    Array(Array('0')),
    expect = 0
  )

  testCase(
    Array(Array('1')),
    expect = 1
  )

  testCase(
    Array(Array('0', '1', '0')),
    expect = 1
  )

  testCase(
    Array(Array('1', '0', '1')),
    expect = 2
  )

  testCase(
    Array(
      Array('1', '0'),
      Array('0', '1')
    ),
    expect = 2
  )

  testCase(
    Array(
      Array('1', '1'),
      Array('0', '1')
    ),
    expect = 1
  )

  testCase(
    Array(
      Array('1', '0', '0'),
      Array('0', '0', '1'),
      Array('0', '1', '1')
    ),
    expect = 2
  )
}
