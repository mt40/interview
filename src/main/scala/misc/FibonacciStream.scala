package misc

/**
  * Returns a stream that contains Fibonacci numbers.
  * @see https://en.wikipedia.org/wiki/Fibonacci_number
  */
object FibonacciStream {
  def apply(): Stream[Long] = {
    // approach 1
//    def loop(a: Long, b: Long): Stream[Long] = (a + b) #:: loop(b, a + b)
//    0 #:: 1 #:: loop(0, 1)

    // approach 2
    lazy val fib: Stream[Long] = 0 #:: fib.scanLeft(1L)(_ + _)
    fib
  }
}
