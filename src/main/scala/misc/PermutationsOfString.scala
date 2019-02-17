package misc

/**
  * Returns all permutation of a given string.
  * For example, result of "abc" is: abc, acb, bac, bca, cab, cba
  */
object PermutationsOfString {

  def apply(s: String): Stream[String] = {
    if(s.isEmpty) {
      Stream(s)
    }
    else {
      val permOfIndices = PermutationsOfNumber(s.length - 1)
      permOfIndices.map(_.map(s.charAt).mkString)
    }
  }
}
