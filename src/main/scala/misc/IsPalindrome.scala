package misc

import scala.annotation.tailrec

/**
  * Returns `true` if the given string is a palindrome.
  * Time: O(n)
  */
object IsPalindrome {

  def apply(s: String): Boolean = {
    @tailrec
    def loop(l: Int, r: Int): Boolean = {
      if (l >= r) true
      else if (s(l) != s(r)) false
      else loop(l + 1, r - 1)
    }

    loop(0, s.length - 1)
  }
}
