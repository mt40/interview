package sorting

import common.SolutionSuite

abstract class SortingSuite extends SolutionSuite {
  protected def sortMethod: Sorting

  private def testCase[A : Ordering](arr: Array[A], expect: Array[A]): Unit = {
    makeTest { sortMethod.sort(arr) should contain theSameElementsInOrderAs expect }
  }

  val intCases = Seq(
    Array.empty[Int],
    Array(1),
    Array(2, 1),
    Array(10, 1, -4),
    Array(10, 10, -4, -4),
    Array(4, 9, 0, 30, -10, 2, 0),
    Array(9, 1, 2, 0)
  )

  intCases.foreach { arr =>
    testCase(arr, expect = arr.sorted)
  }

  intCases.foreach { ints =>
    val strings = ints.map(_.toString)
    testCase(strings, expect = strings.sorted)
  }

  intCases.foreach { ints =>
    val doubles = ints.map(_.toDouble)
    testCase(doubles, expect = doubles.sorted)
  }
}
