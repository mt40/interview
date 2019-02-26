package leetcode

/**
  * Idea:
  * - sort by height first and then by `k`
  * - then do like insertion sort
  * - why sort? because we cannot insert (i,j) if there are not enough i or j
  * in the result yet
  *
  * @see https://leetcode.com/problems/queue-reconstruction-by-height/
  */
object QueueReconstructionByHeight {

  def reconstructQueue(people: Array[Array[Int]]): Array[Array[Int]] = {

    def insert(l: List[Array[Int]], x: Array[Int], k: Int): List[Array[Int]] = {
      l match {
        case Nil         => List(x)
        case _ if k == 0 => x :: l
        case h :: t =>
          if (h.head >= x.head) {
            h :: insert(t, x, k - 1)
          }
          else {
            h :: insert(t, x, k)
          }
      }
    }

    val sorted = people.sortBy(a => (-a(0), a(1)))
    sorted
      .foldLeft(List.empty[Array[Int]]) { (rs, cur) =>
        insert(rs, cur, cur(1))
      }
      .toArray
  }
}
