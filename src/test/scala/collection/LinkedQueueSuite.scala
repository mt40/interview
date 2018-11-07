package collection

import common.SolutionSuite

class LinkedQueueSuite extends SolutionSuite {
  test("build") {
    LinkedQueue(1, 2, 3).front shouldEqual QNode(1, QNode(2, QNode(3)))
  }

  test("'dequeue'") {
    val q = LinkedQueue(1, 2, 3)

    q.dequeue shouldEqual 1
    q.front shouldEqual QNode(2, QNode(3))

    q.dequeue shouldEqual 2
    q.front shouldEqual QNode(3)
  }
}
