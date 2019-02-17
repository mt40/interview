package misc

/** Returns a stream of factorials. */
object FactorialStream {

  def apply(): Stream[Long] = {
    lazy val fact: Stream[Long] = 1 #:: fact.zipWithIndex.map {
      case (f, i) => f * (i + 1)
    }
    fact
  }
}
