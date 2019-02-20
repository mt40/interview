package leetcode

import scala.annotation.tailrec

/** @see https://leetcode.com/problems/letter-combinations-of-a-phone-number */
object LetterCombinationsOfAPhoneNumber {

  def letterCombinations(digits: String): List[String] = {
    val keyMap = Map(
      '2' -> List("a", "b", "c"),
      '3' -> List("d", "e", "f"),
      '4' -> List("g", "h", "i"),
      '5' -> List("j", "k", "l"),
      '6' -> List("m", "n", "o"),
      '7' -> List("p", "q", "r", "s"),
      '8' -> List("t", "u", "v"),
      '9' -> List("w", "x", "y", "z")
    )

    @tailrec
    def loop(s: String, rs: List[String]): List[String] = {
      s match {
        case "" => rs
        case _ =>
          val keys = keyMap(s.head)
          loop(s.tail, rs.flatMap(c => keys.map(c + _)))
      }
    }

    if (digits.isEmpty) List.empty
    else loop(digits, List(""))
  }
}
