package leetcode

import scala.annotation.tailrec

/**
  * Idea: greedy, if person 1 is in a boat, try to find another
  * heaviest person that can fit in the other seat. If we cannot
  * find such a pair, we pick the currently heaviest to the boat
  * first and then repeat the process.
  */
object BoatsToSavePeople {

  def numRescueBoats(people: Array[Int], limit: Int): Int = {
    @tailrec
    def loop(sorted: Array[Int], l: Int, r: Int, boats: Int): Int = {
      if (r < l) {
        boats
      }
      else {
        val min = sorted(l)
        val max = sorted(r)
        if (min + max <= limit) loop(sorted, l + 1, r - 1, boats + 1)
        else loop(sorted, l, r - 1, boats + 1)
      }
    }

    loop(people.sorted, 0, people.length - 1, 0)
  }
}
