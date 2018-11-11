package leetcode

object TwoSum {

  /**
    * The idea is to check the visited elements to see if the other number is there
    * while iterating throught the given array.
    * Time: O(n)
    */
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val state = (Map.empty[Int, Int], Array.empty[Int])

    nums.zipWithIndex
      .foldLeft(state) {
        case ((seen, rs), (next, i)) =>
          val other = target - next
          seen.get(other) match {
            case None    => (seen + (next -> i), rs)
            case Some(j) => (seen + (next -> i), Array(i, j))
          }
      }
      ._2
  }
}
