package collection

import common.SolutionSuite

class LinkedListSuite extends SolutionSuite {
  test("build list") {
    LinkedList.apply[Int]() shouldEqual Empty
    LinkedList(1, 1) shouldEqual Node(1, Node(1, Empty))
    LinkedList(1, 2, 3) shouldEqual Node(1, Node(2, Node(3, Empty)))
  }

  test("'concat'") {
    LinkedList(1, 2, 3) concat Empty shouldEqual LinkedList(1, 2, 3)
    Empty concat LinkedList(1, 2, 3) shouldEqual LinkedList(1, 2, 3)
    LinkedList(1, 2) concat LinkedList(3, 5) shouldEqual LinkedList(1, 2, 3, 5)
  }

  test("'reversed'") {
    Empty.reversed shouldEqual Empty
    LinkedList(1).reversed shouldEqual LinkedList(1)
    LinkedList(1, 2, 3).reversed shouldEqual LinkedList(3, 2, 1)
  }

  test("'map'") {
    LinkedList(1, 2, 3).map(_ + 1) shouldEqual LinkedList(2, 3, 4)
    LinkedList(1, 2, 3).map(_.toString) shouldEqual LinkedList("1", "2", "3")
  }

  test("'flatMap'") {
    LinkedList(1).flatMap(x => LinkedList(x, x + 1)) shouldEqual LinkedList(1, 2)
    LinkedList(1, 2).flatMap(x => LinkedList(x, x)) shouldEqual LinkedList(1, 1, 2, 2)
  }

  test("'contains'") {
    LinkedList.empty[Int].contains(1) shouldEqual false
    LinkedList(10, 2, 1).contains(1) shouldEqual true
    LinkedList(10, 2, 1).contains(3) shouldEqual false
  }

  test("'apply(Int)'") {
    val l = LinkedList(10, 2, 1)
    l(0) shouldEqual 10
    l(2) shouldEqual 1
    an[IndexOutOfBoundsException] should be thrownBy l(3)
  }

  test("'filter'") {
    val l = LinkedList(10, 2, 1, 4, 2, 20)
    l.filter(_ > 5) shouldEqual LinkedList(10, 20)
    l.filter(_ == 2) shouldEqual LinkedList(2, 2)
    l.filter(_ < 0) shouldEqual LinkedList.empty[Int]
  }

  test("'foldLeft'") {
    LinkedList.empty[Int].foldLeft(0)(_ + _) shouldEqual 0

    val l = LinkedList(10, 2, 1, 4, 2, 20)
    l.foldLeft(0)(_ + _) shouldEqual 39
    l.foldLeft("")(_ + ", " + _) shouldEqual ", 10, 2, 1, 4, 2, 20"
  }
}
