package leetcode

/** @see https://leetcode.com/problems/group-anagrams */
object GroupAnagrams {

  def groupAnagrams(strings: Array[String]): List[List[String]] = {
    val map = Map.empty[String, List[String]]
    strings
      .foldLeft(map) { (rs, s) =>
        val key = s.sorted
        rs.updated(key, s :: rs.getOrElse(key, List.empty))
      }
      .toList
      .map(_._2)
  }
}
