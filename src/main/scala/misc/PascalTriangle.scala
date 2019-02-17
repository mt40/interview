package misc

/**
  * Returns the Pascal Triangle given its height.
  * For example:
  * {{{
  *   // height = 1
  *   1
  *   // height = 3
  *     1
  *    1 1
  *   1 2 1
  * }}}
  *
  * @see https://en.wikipedia.org/wiki/Pascal%27s_triangle
  */
object PascalTriangle {

  def apply(height: Int): String = {
    height match {
      case 0 => ""
      case _ =>
        (2 to height)
          .scanLeft(Seq(1)) { (prevRow, h) =>
            (0 until h) map { i =>
              if (i == 0 || i == h - 1) 1
              else prevRow(i - 1) + prevRow(i)
            }
          }
          .zipWithIndex
          .map {
            case (row, idx) =>
              val indent = " " * (height - idx - 1)
              indent + row.mkString(" ")
          }
          .mkString("\n")
    }
  }
}
