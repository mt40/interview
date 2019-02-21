package leetcode

/**
  * Idea:
  * - use dynamic programming, dp(i, j) = result of substring from i to j (inclusive)
  * - dp(i, j) is true if:
  *   + substring(i, j) is in the dictionary
  *   + dp(i, k) = true and dp(k + 1, j) = true, where k runs from i to j - 1
  * - dp(i, j) is false otherwise
  * - result is in dp(0, n - 1)
  *
  * @see https://leetcode.com/problems/word-break/
  */
object WordBreak {

  def wordBreak(s: String, wordDict: List[String]): Boolean = {
    val n = s.length
    val dict = wordDict.toSet

    val dp = Array.fill(n, n)(false)
    (1 to n).foreach { len =>
      (0 until n).foreach { l =>
        val r = l + len - 1
        if (r < n) {
          val sub = s.substring(l, r + 1)

          dp(l)(r) = dict.contains(sub)
          (l until r).foreach { k =>
            if (dp(l)(k) && dp(k + 1)(r)) dp(l)(r) = true
          }
        }
      }
    }

    dp(0)(n - 1)
  }
}
