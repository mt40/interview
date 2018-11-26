package misc

import scala.annotation.tailrec

/**
  * Returns the longest palindromic substring in the given string.
  * Time: O(n^2)
  **/
object LongestPalindromicSubstring {
  private case class Result(l: Int, r: Int, length: Int)

  def apply(s: String): String = {
    @tailrec
    def loop(l: Int, r: Int): String = {
      if (l < 0 || r >= s.length || s(l) != s(r)) s.substring(l + 1, r)
      else loop(l - 1, r + 1)
    }

    s.indices.foldLeft("") { (rs, i) =>
      // find the longest palindrome with:
      // - i and i + 1 at the middle (if palindrome has even length)
      // - i at the middle (if palindrome has odd length)
      val candidate = longer(loop(i, i + 1), loop(i, i))
      longer(rs, candidate)
    }
  }

  private def longer(a: String, b: String): String = {
    if (a.length >= b.length) a else b
  }
}
