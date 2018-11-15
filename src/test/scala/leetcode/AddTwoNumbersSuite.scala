package leetcode

import common.SolutionSuite
import leetcode.AddTwoNumbers.ListNode

import scala.annotation.tailrec

class AddTwoNumbersSuite extends SolutionSuite {

  object ListNode {

    def toInt(l: ListNode): Int = {
      @tailrec
      def loop(i: ListNode, idx: Int, rs: String): String = {
        if (i == null) rs
        else loop(i.next, idx + 1, i.x + rs)
      }
      loop(l, 1, "").toInt
    }

    def fromInt(i: Int): ListNode = {
      val start: ListNode = null
      i.toString.map(_.toString.toInt).foldLeft(start) { (l, next) =>
        val node = new ListNode(next)
        node.next = l
        node
      }
    }
  }

  private def testCase(a: Int, b: Int, expect: Int) = {
    test(s"$a + $b") {
      val la = ListNode.fromInt(a)
      val lb = ListNode.fromInt(b)
      val rs = AddTwoNumbers.addTwoNumbers(la, lb)
      ListNode.toInt(rs) shouldEqual expect
    }
  }

  testCase(342, 465, expect = 807)
  testCase(40, 0, expect = 40)
  testCase(0, 0, expect = 0)
  testCase(0, 123, expect = 123)
  testCase(5000, 12, expect = 5012)
}
