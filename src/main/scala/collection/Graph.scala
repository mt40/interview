package collection

import collection.Graph._

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
  * A graph represented by adjacent list. For simplicity, we
  * use Int for vertex and edge weight.
  * Vertex number starts from 0.
  */
class Graph(vertices: Int) {
  private val adjList = ArrayBuffer.fill(vertices)(Vector.empty[Edge])

  def addEdge(from: Int, to: Int): Graph = {
    adjList(from) = adjList(from) :+ Edge(from, to)
    this
  }

  def collectDFS: Seq[Int] = {
    def dfs(v: Int, visited: mutable.Set[Int], collected: ArrayBuffer[Int]): Unit = {
      if (!visited.contains(v)) {
        visited += v
        collected += v
        adjList(v).foreach(next => dfs(next.to, visited, collected))
      }
    }

    val collected = ArrayBuffer.empty[Int]
    val visited = mutable.Set.empty[Int]
    (0 until vertices).foreach(v => dfs(v, visited, collected))
    collected
  }

  def collectBFS: Seq[Int] = {
    val collected = ArrayBuffer.empty[Int]
    val visited = mutable.Set.empty[Int]
    val toVisit = mutable.Queue.empty[Int]

    (0 until vertices).foreach { v =>
      if (!visited.contains(v)) {
        toVisit += v
        while (toVisit.nonEmpty) {
          val next = toVisit.dequeue
          collected += next
          visited += next
          toVisit ++= adjList(next).map(_.to).filterNot(visited.contains)
        }
      }
    }

    collected
  }

  override def toString: String = {
    val strings = {
      (0 until vertices).map { v =>
        if (adjList(v).isEmpty) v.toString
        else v.toString + " -> " + adjList(v).map(_.to).mkString(", ")
      }
    }
    strings.mkString("\n")
  }
}

object Graph {
  case class Edge(from: Int, to: Int) {
    override def toString: String = s"$from -> $to"
  }
}
