package searching

class BinarySearchGenericSuite extends BinarySearchSuite {

  private def testCase[A : Ordering](a: Array[A], x: A, expect: Int): Unit = {
    makeTest { new BinarySearchGeneric().run(a, x) shouldEqual expect }
  }

  testCase(Array("a", "b", "c"), "b", expect = 1)
  testCase(Array("a", "b", "c"), "a", expect = 0)
  testCase(Array("a", "b", "c"), "d", expect = 3)
  testCase(Array("a", "b", "c", "h"), "d", expect = 3)
  testCase(Array("a", "c", "f", "h"), "b", expect = 1)

  testCase(Array(1.2, 4.5), 4.0, expect = 1)
  testCase(Array(1.2f, 4.5f), 4f, expect = 1)

}
