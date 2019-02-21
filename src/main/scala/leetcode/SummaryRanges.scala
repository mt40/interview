package leetcode

import scala.annotation.tailrec

object SummaryRanges {

  def summaryRanges(nums: Array[Int]): List[String] = {
    @tailrec
    def loop(i: Int, rs: List[Range]): List[Range] = {
      val n = nums.length
      i match {
        case `n` => rs
        case 0   => loop(i + 1, (nums.head to nums.head) +: rs)
        case _ =>
          val head = rs.head
          val next = nums(i)
          if (next == head.end + 1) {
            loop(i + 1, (head.start to next) +: rs.tail)
          }
          else {
            loop(i + 1, (next to next) +: rs)
          }
      }
    }

    loop(0, List.empty).reverse.map { r =>
      if (r.length == 1) r.start.toString
      else s"${r.start}->${r.end}"
    }
  }
}
