package leetcode

/** @see https://leetcode.com/problems/multiply-strings/ */
object MultiplyStrings {
  // for each digit d from right to left of 2nd number
  // multiply d with first number (and multiply 10 according to index)
  // sum all those smaller products

  def multiply(num1: String, num2: String): String = {
    val rs = (num2.length - 1 to 0 by -1).foldLeft("0") { (rs, i) =>
      val p = simpleMultiply(num1, num2.charAt(i).toString.toInt)
      val tens = num2.length - 1 - i
      val mul10 = multiply10(p, tens)
      add(rs, mul10)
    }

    stripLeadingZeros(rs)
  }

  private def simpleMultiply(num: String, d: Int): String = {
    // multiply d with each digit of num from right to left
    // at digit i:
    // - if there is a remembered value, add that to the product at i
    // - after that, if product > 9, remember product / 10, append the mod to rs
    // if i == 0, no need to remember
    def loop(i: Int, rem: Int, rs: StringBuilder): String = {
      val p = num.charAt(i).toString.toInt * d + rem
      val r = p / 10
      val m = p % 10
      if (i == 0) p.toString ++ rs.reverse.toString()
      else loop(i - 1, r, rs.append(m))
    }

    loop(num.length - 1, 0, new StringBuilder())
  }

  private def stripLeadingZeros(num: String): String = {
    val stripped = num.dropWhile(_ == '0')
    if (stripped.isEmpty) "0" else stripped
  }

  private def multiply10(num: String, tens: Int): String = {
    val postfix = "0" * tens
    num ++ postfix
  }

  private def add(num1: String, num2: String): String = {
    // prefix the shorter number with 0s to make 2 numbers equal sized
    // from right to left, add corresponding digit + rem
    // if sum > 9, rem = sum / 10, append mod to rs
    def loop(a: String, b: String, i: Int, rem: Int, rs: StringBuilder): String = {
      val da = a.charAt(i).toString.toInt
      val db = b.charAt(i).toString.toInt
      val sum = da + db + rem
      val r = sum / 10
      val m = sum % 10
      if (i == 0) sum.toString ++ rs.reverse.toString()
      else loop(a, b, i - 1, r, rs.append(m))
    }

    val n = math.max(num1.length, num2.length)
    if (num1.length < n) {
      loop(pad(num1, n), num2, n - 1, 0, new StringBuilder())
    }
    else {
      loop(num1, pad(num2, n), n - 1, 0, new StringBuilder())
    }
  }

  private def pad(s: String, length: Int): String = {
    val zeros = "0" * (length - s.length)
    zeros ++ s
  }
}
