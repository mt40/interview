package leetcode

import scala.annotation.tailrec

/**
  * Idea: use a stack to store open brackets, pop the stack if its top is the open bracket of the
  * close bracket we are looking at. If top of stack is not the same type or at the end the
  * stack is not empty, return false.
  *
  * Complexity: O(n)
  *
  * @see https://leetcode.com/problems/valid-parentheses/
  */
object ValidParentheses {

  def isValid(s: String): Boolean = {
    @tailrec
    def loop(i: Int, stack: List[Char]): Boolean = {
      if (i == s.length) {
        stack.isEmpty
      }
      else {
        s.charAt(i) match {
          case close @ (')' | ']' | '}') =>
            if (stack.headOption.contains(openBracketOf(close))) loop(i + 1, stack.tail)
            else false
          case open =>
            loop(i + 1, open :: stack)
        }
      }
    }

    loop(0, List.empty)
  }

  private def openBracketOf(c: Char): Char = {
    c match {
      case ')' => '('
      case ']' => '['
      case '}' => '{'
    }
  }
}
