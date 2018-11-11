package collection

import common.SolutionSuite

class GraphSuite extends SolutionSuite {

  private val graph = new Graph(vertices = 6)
  graph
    .addEdge(from = 0, to = 1)
    .addEdge(from = 0, to = 4)
    .addEdge(from = 1, to = 3)
    .addEdge(from = 3, to = 2)
    .addEdge(from = 2, to = 1)

  test("build") {
    graph.toString shouldEqual "0 -> 1, 4\n1 -> 3\n2 -> 1\n3 -> 2\n4\n5"
  }

  test("dfs") {
    graph.collectDFS shouldEqual Seq(0, 1, 3, 2, 4, 5)
  }

  test("bfs") {
    graph.collectBFS shouldEqual Seq(0, 1, 4, 3, 2, 5)
  }
}
