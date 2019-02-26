package leetcode

import common.SolutionSuite

class TaskSchedulerSuite extends SolutionSuite {
  private def testCase(tasks: Array[Char], n: Int, expect: Int) = {
    test(s"Schedule tasks ${tasks.prettyString} cool-down $n") {
      TaskScheduler.leastInterval(tasks, n) shouldEqual expect
    }
  }

  testCase("AAABBB".toCharArray, 2, expect = 8)
  testCase("ABCABCABCDED".toCharArray, 2, expect = 12)
  testCase("AABBC".toCharArray, 2, expect = 5)
  testCase("AA".toCharArray, 2, expect = 4)
  testCase("AAAAAABCDEFG".toCharArray, 2, expect = 16)
}
