package leetcode

import scala.collection.mutable

/** @see https://leetcode.com/problems/task-scheduler */
object TaskScheduler {

  def leastInterval(tasks: Array[Char], n: Int): Int = {
    // find the task with max count C
    // C creates I = (C - 1) * n idle slots
    // now final_idle = I - (remaining number of tasks), if < 0, = 0
    // rs = final_idle + total number of tasks
    val abc = mutable.Map.empty[Char, Int]
    tasks.foreach { t =>
      abc.update(t, abc.getOrElse(t, 0) + 1)
    }

    val sortedCounts = abc.values.toSeq.sorted(implicitly[Ordering[Int]].reverse)

    val maxCount = sortedCounts.head
    var idles = (maxCount - 1) * n

    sortedCounts.tail.foreach { v =>
      idles -= math.min(maxCount - 1, v)
    }

    sortedCounts.sum + math.max(0, idles)
  }
}
