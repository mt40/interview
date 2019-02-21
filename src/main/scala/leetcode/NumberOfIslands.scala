package leetcode

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
  * Idea: use DFS to traverse cell with '1', each DFS run will traverse 1 whole island
  * so we just need to count how many DFS we can run
  *
  * Complexity: O(n) where n is the number of cells
  *
  * @see https://leetcode.com/problems/number-of-islands/
  */
object NumberOfIslands {

  def numIslands(grid: Array[Array[Char]]): Int = {
    if (grid.isEmpty) {
      0
    }
    else {
      val cols = grid.length
      val rows = grid(0).length
      val vertices = cols * rows

      def vertexFor(i: Int, j: Int): Int = i * rows + j

      val graph = Array.fill(vertices)(ArrayBuffer.empty[Int])
      (0 until cols) map { i =>
        (0 until rows) map { j =>
          val v = vertexFor(i, j)
          if (grid(i)(j) == '1') {
            if (j + 1 < rows && grid(i)(j + 1) == '1') {
              val u = vertexFor(i, j + 1)
              graph(v) += u
              graph(u) += v
            }
            if (i + 1 < cols && grid(i + 1)(j) == '1') {
              val u = vertexFor(i + 1, j)
              graph(v) += u
              graph(u) += v
            }
          }
        }
      }

      val visited = mutable.Set.empty[Int]
      var isLands = 0
      (0 until cols) foreach { i =>
        (0 until rows) foreach { j =>
          val v = vertexFor(i, j)
          if (!visited.contains(v) && grid(i)(j) == '1') {
            dfs(graph, v, visited)
            isLands += 1
          }
        }
      }

      isLands
    }
  }

  private def dfs(graph: Array[ArrayBuffer[Int]], v: Int, visited: mutable.Set[Int]): Unit = {
    graph(v).foreach { u =>
      if (!visited.contains(u)) {
        visited += u
        dfs(graph, u, visited)
      }
    }
  }
}
