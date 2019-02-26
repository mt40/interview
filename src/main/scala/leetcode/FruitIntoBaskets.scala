package leetcode

import scala.annotation.tailrec

/**
  * Idea:
  * - we can keep maximum 2 types of tree, let say t1 and t2
  * - if tree(i) is either t1 or t2, add to our list
  * - else, we can keep the most recently picked tree type in the list and add tree(i)
  * - result is the max length of list seen during the run
  *
  * Complexity: O(n)
  *
  * @see https://leetcode.com/problems/fruit-into-baskets/
  */
object FruitIntoBaskets {

  def totalFruit(tree: Array[Int]): Int = {
    @tailrec
    def loop(i: Int, picked: List[Int], seen: Set[Int], rs: Int): Int = {
      if (i == tree.length) {
        rs
      }
      else {
        val fruit = tree(i)
        if (!seen.contains(fruit) && seen.size == 2) {
          val newPicked = fruit :: picked.takeWhile(_ == picked.head)
          val newRs = math.max(rs, newPicked.length)
          loop(i + 1, newPicked, Set(fruit, newPicked.last), newRs)
        }
        else {
          val newPicked = fruit :: picked
          val newRs = math.max(rs, newPicked.length)
          loop(i + 1, newPicked, seen + fruit, newRs)
        }
      }
    }

    loop(0, List.empty, Set.empty, 0)
  }
}
