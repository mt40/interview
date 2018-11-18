package leetcode

object LongestAbsoluteFilePath {

  def lengthLongestPath(input: String): Int = {
    val parts = input.split("\n")
    var rs = 0
    var lengthUntil = Map[Int, Int]()
    parts.foreach { pt =>
      val (level, length, isFile) = inspect(pt)
      val parent = lengthUntil.getOrElse(level - 1, 0)
      val here = parent + length
      if (isFile) rs = math.max(rs, here)
      else lengthUntil = lengthUntil + (level -> (here + 1)) // +1 for backslash
    }

    rs
  }

  private def inspect(s: String): (Int, Int, Boolean) = {
    val parts = s.split("\t")
    val level = parts.length - 1
    val length = parts.last.length
    val isFile = parts.last.contains(".")
    (level, length, isFile)
  }
}
