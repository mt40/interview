package collection

import common.SolutionSuite

class HashMapSuite extends SolutionSuite {
  test("build") {
    def check[K : Ordering, V](map: HashMap[K, V], expect: Seq[(K, V)]): Unit = {
      map.toSeq.sortBy(_._1) shouldEqual expect
    }

    check(HashMap("a" -> 1), expect = Seq("a" -> 1))
    check(HashMap("a" -> 1, "a" -> 3, "b" -> 2), expect = Seq("a" -> 3, "b" -> 2))
  }

  test("'remove'") {
    def check[K : Ordering, V](map: HashMap[K, V], expect: Seq[(K, V)]): Unit = {
      map.toSeq.sortBy(_._1) shouldEqual expect
    }

    check(HashMap("a" -> 1).remove("a"), expect = Seq())
    check(HashMap("a" -> 1, "a" -> 3, "b" -> 2).remove("a"), expect = Seq("b" -> 2))
    check(HashMap("a" -> 1, "a" -> 3, "b" -> 2).remove("b"), expect = Seq("a" -> 3))
  }

  test("'get'") {
    HashMap("a" -> 1).get("a") shouldEqual Some(1)
    HashMap("a" -> 1).get("b") shouldEqual None
    HashMap("a" -> 1, "a" -> 3, "b" -> 2).get("a") shouldEqual Some(3)
  }

}
