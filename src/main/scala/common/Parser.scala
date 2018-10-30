package common

trait Parser[A] {
  def apply(arg: String): A
}

object Parser extends ParserInstances

trait ParserInstances {
  private def instance[A](f: String => A): Parser[A] = {
    new Parser[A] {
      def apply(arg: String): A = f(arg)
    }
  }

  implicit def parseInt: Parser[Int] =
    instance(_.toInt)

  implicit def parseIntArray: Parser[Array[Int]] =
    instance(_.split(' ').map(_.toInt))
}
