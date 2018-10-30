import common.{Parser, Question}

/** Search for `x` in `arr`. */
case class Input(arr: Array[Int], x: Int)

object Input {
  implicit def p: Parser[Input] = {
    import Parser._
    intArray and int
  }
}

class BinarySearch extends Question[Input, Array[Int]] {
  override def run(in: Input): Array[Int] = {
    in.arr
  }
}
