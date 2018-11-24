package misc

object LongestCommonSubSequence {

  /**
    * Returns the longest common sub-sequence of the 2 given strings.
    * Sub-sequence of 2 strings is a sequence of characters appear
    * in both strings (i.e. has order and no need to be continuous).
    *
    * This implementation returns only 1 of the possible solution.
    *
    * Time: O(n*m)
    */
  def apply(a: String, b: String): String = {
    val dp = Array.fill(a.length, b.length)(new Entry())
    for {
      i <- 0 until a.length
      j <- 0 until b.length
    } {
      if (a(i) == b(j)) {
        val prev = if(i * j == 0) Entry.zero else dp(i - 1)(j - 1)
        dp(i)(j) = prev.add(a(i))
      }
      else {
        dp(i)(j) = Entry.max(
          if (j == 0) Entry.zero else dp(i)(j - 1),
          if (i == 0) Entry.zero else dp(i - 1)(j)
        )
      }
    }

    dp.last.last.str
  }

  private class Entry(val lcs: Int = 0, val str: String = "") {
    def add(c: Char): Entry = new Entry(lcs + 1, str + c)
  }

  private object Entry {
    def zero: Entry = new Entry()

    def max(a: Entry, b: Entry): Entry = {
      Seq(a, b).maxBy(_.lcs)
    }
  }
}
