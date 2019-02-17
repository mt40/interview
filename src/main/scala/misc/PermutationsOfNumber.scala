package misc

/**
  * Returns all permutation of a sequence of number from 0 to n (inclusive).
  * For example, result of n=1 is: (0, 1), (1, 0)
  */
object PermutationsOfNumber {

  def apply(n: Int): Stream[Seq[Int]] = {
    val nums = (0 to n).toVector
    gen(nums)
  }

  private def gen(nums: Seq[Int]): Stream[Seq[Int]] = {
    nums match {
      case _ if nums.isEmpty => Stream.empty
      case Seq(_)            => Stream(nums)
      case _ =>
        nums.toStream.flatMap { pick =>
          val remain = nums.filter(_ != pick)
          gen(remain).map(pick +: _)
        }
    }
  }
}
