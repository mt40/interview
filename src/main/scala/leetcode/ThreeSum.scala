package leetcode

object ThreeSum {

  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val zipped = nums.toList.zipWithIndex

    val triplets = for {
      (a, i) <- zipped
      (b, j) <- zipped if j != i
      (c, k) <- zipped if k != i && k != j
    } yield {
      if (a + b + c == 0) List(a, b, c).sorted
      else List.empty
    }

    triplets.filter(_.nonEmpty).distinct
  }
}
