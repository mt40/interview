package collection

import common.SolutionSuite

class BankersQueueSuite extends SolutionSuite {
  test("build") {
    BankersQueue.empty[Int] shouldEqual BankersQueue(Nil, Nil)
    BankersQueue(1, 2, 3) shouldEqual BankersQueue(List(3, 2, 1), Nil)
  }

  test("'enqueue' & 'dequeue'") {
    BankersQueue(1, 2, 3).dequeue shouldEqual (1, BankersQueue(Nil, List(2, 3)))
    BankersQueue(2, 3).dequeue shouldEqual (2, BankersQueue(Nil, List(3)))
    BankersQueue(2, 3).dequeue._2.enqueue(1) shouldEqual BankersQueue(List(1), List(3))
    BankersQueue(3).dequeue shouldEqual (3, BankersQueue(Nil, Nil))
    a[NoSuchElementException] should be thrownBy BankersQueue.empty[Int].dequeue
  }
}
