package misc

object LongestCommonSubstring {

  /**
    * Returns the longest common substring of the 2 given strings.
    * Time: O(n*m)
    *
    * There is another solution using Suffix Array running in
    * O((n+m)log(n+m))
    */
  def apply(a: String, b: String): String = {
    var rs = (0, 0) // end index and length
    // compute the longest common suffix length
    val lcsuff = Array.fill(a.length, b.length)(0)
    for {
      i <- 0 until a.length
      j <- 0 until b.length
    } {
      if (a(i) == b(j)) {
        lcsuff(i)(j) = if(i * j == 0) 1 else lcsuff(i - 1)(j - 1) + 1
        if (lcsuff(i)(j) > rs._2) rs = (i, lcsuff(i)(j))
      }
      else {
        lcsuff(i)(j) = 0
      }
    }

    a.substring(rs._1 + 1 - rs._2, rs._1 + 1)
  }
}
