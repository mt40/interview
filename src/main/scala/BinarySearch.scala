import common.{Parseable, Question}

/** Search for `x` in `arr`. */
case class Input(arr: Array[Int], x: Int)

object Input {
  implicit def p: Parseable[Input] = {
    import Parseable._
    intArray and int
  }
}

class BinarySearch extends Question[Input, Array[Int]] {
  override def run(in: Input): Array[Int] = {
    in.arr
  }
}
