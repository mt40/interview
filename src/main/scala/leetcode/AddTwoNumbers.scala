package leetcode

/**
  * This problem statement is horrible. It forces mutability and it doesn't even
  * use Scala's List. Not like it...
  */
object AddTwoNumbers {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = None.orNull
    var x: Int = _x
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var (i, j) = (l1, l2)
    var remainder = 0
    var rs: ListNode = None.orNull
    var rsHead: ListNode = rs
    while (i != null || j != null) {
      val a = if (i == null) 0 else i.x
      val b = if (j == null) 0 else j.x
      val cur = a + b + remainder
      val nextDigit = new ListNode(cur % 10)

      if (rs == null) {
        rs = nextDigit
        rsHead = rs
      }
      else {
        rs.next = nextDigit
        rs = nextDigit
      }

      remainder = cur / 10
      i = if (i == null) i else i.next
      j = if (j == null) j else j.next
    }

    if (remainder > 0) rs.next = new ListNode(remainder)

    rsHead
  }
}
