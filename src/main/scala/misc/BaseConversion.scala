package misc

import scala.annotation.tailrec

object BaseConversion {

  /**
    * Returns a binary representation of the given integer.
    * This method can handle negative integers.
    */
  def toBinary(i: Int): String = {
    @tailrec
    def loop(n: Int, rs: List[Int]): List[Int] = {
      n match {
        case 0 if rs.isEmpty => 0 +: rs
        case 0               => rs
        case _               => loop(n / 2, n % 2 +: rs)
      }
    }

    if (i >= 0) {
      loop(i, Nil).mkString("")
    }
    else {
      val b = padTo(loop(-i, Nil), 32)
      val lastSetBit = b.lastIndexOf(1)
      val flipped = b.slice(0, lastSetBit).map(1 - _)
      (flipped ++ b.slice(lastSetBit, b.length)).mkString("")
    }
  }

  private def padTo(l: List[Int], length: Int): List[Int] = {
    val toPrepend = length - l.length
    if (toPrepend <= 0) l
    else List.fill(toPrepend)(0) ++ l
  }
}
