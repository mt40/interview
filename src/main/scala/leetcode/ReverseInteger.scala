package leetcode

import scala.util.Try

object ReverseInteger {

  def reverse(x: Int): Int = {
    val s = x.toString
    val rv = if (x < 0) s.tail.reverse else s.reverse
    val rs = Try {
      if (x < 0) s"-$rv".toInt else rv.toInt
    } recover {
      case _: NumberFormatException => 0
    }
    rs.get
  }
}
