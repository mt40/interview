package misc

/**
  * Sorts 3 numbers in ascending order without using built-in sort methods.
  * I will try to use as less comparisons as possible.
  *
  * Idea:
  * - Let say we have (a, b, c)
  * - We try to sort a & c, so now a & c are in order. Let say a <= c so a must be before c
  * - Then b can only either swap with a or c, otherwise order of a & c will not be maintained.
  * => We need at most 3 comparisons
  *
  * Complexity: O(1)
  */
object Sort3Numbers {

  def apply(a: Int, b: Int, c: Int): (Int, Int, Int) = {
    var rs = (a, b, c)
    rs = if (rs._1 > rs._3) (rs._3, rs._2, rs._1) else rs
    rs = if (rs._2 > rs._3) (rs._1, rs._3, rs._2) else rs
    if (rs._1 > rs._2) (rs._2, rs._1, rs._3) else rs
  }
}
