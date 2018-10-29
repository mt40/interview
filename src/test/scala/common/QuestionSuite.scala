package common

import org.scalatest.{FunSuite, Matchers}

abstract class QuestionSuite extends FunSuite with Matchers {
  private var testCases: Int = 0

  protected val question: Question[_, _]

  protected final def testCase[A](input: Array[String], expect: A): Unit = {
    testCases += 1
    val name = s"Test $testCases"

    test(name) {
      question.runMain(input) shouldEqual expect
    }
  }
}
