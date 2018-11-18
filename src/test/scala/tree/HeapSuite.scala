package tree

import common.SolutionSuite

class HeapSuite extends SolutionSuite {
  test("build") {
    Heap.empty[Int].toSeq shouldEqual Seq.empty[Int]
    Heap(1).toSeq shouldEqual Seq(1)
    Heap(1, 2).toSeq shouldEqual Seq(2, 1)
    Heap(1, 2, 3).toSeq shouldEqual Seq(3, 1, 2)
    Heap(11, 5, 8, 3, 4).toSeq shouldEqual Seq(11, 5, 8, 3, 4)
  }

  test("'remove'") {
    val heap = Heap(11, 5, 8, 3, 4)
    heap.remove() shouldEqual 11
    heap.toSeq shouldEqual Seq(8, 5, 4, 3)
  }
}
