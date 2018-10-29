import common.{Question, QuestionSuite}

class BinarySearchSuite extends QuestionSuite {

  override protected val question: Question[_, _] = new BinarySearch()

  testCase(Array("1 2 3", "2"), expect = 1)

}
