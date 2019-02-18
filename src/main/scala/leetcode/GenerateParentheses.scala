package leetcode

/** @see https://leetcode.com/problems/generate-parentheses/ */
object GenerateParentheses {

  def generateParenthesis(n: Int): List[String] = {
    n match {
      case 0 => List.empty
      case _ =>
        def loop(open: Int, close: Int, max: Int, cur: String, rs: List[String]): List[String] = {
          if (cur.length == n * 2) {
            cur +: rs
          }
          else {
            val addOpen =
              if (open < max) loop(open + 1, close, max, cur + "(", rs) else List.empty
            val addClose =
              if (close < open) loop(open, close + 1, max, cur + ")", rs) else List.empty
            rs ++ addOpen ++ addClose
          }
        }

        loop(0, 0, n, "", List.empty)
    }
  }
}
