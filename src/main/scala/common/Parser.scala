package common

import shapeless.{Generic, HList}

/** Evidence that `A` can be parsed from `Array[String]`. */
trait Parser[A] {

  /**
    * Parse a list of arguments.
    * @param args arguments. For example, a list and a number:
    *             ["1 2 3", "5"]
    */
  def parse(args: Iterator[String]): A

  def and[B](p: Parser[B]): Parser[(A, B)] = {
    Parser.instance { args =>
      val a = this.parse(args)
      val b = p.parse(args)
      (a, b)
    }
  }

  def map[B](f: A => B): Parser[B] =
    Parser.instance(args => f(this.parse(args)))
}

object Parser extends Instances {
  // TODO: always flatten tuple
  implicit def tuple2CaseClass[A, B <: Product, Repr <: HList](
    p: Parser[A]
  )(implicit
    ga: Generic.Aux[A, Repr],
    gb: Generic.Aux[B, Repr]
  ): Parser[B] = {
    p.map(a => gb.from(ga.to(a)))
  }
}

trait Instances {

  def instance[A](f: Iterator[String] => A): Parser[A] = {
    new Parser[A] {
      override def parse(args: Iterator[String]): A = f(args)
    }
  }

  implicit def int: Parser[Int] =
    instance(_.next.toInt)

  implicit def intArray: Parser[Array[Int]] =
    instance(_.next.split(' ').map(_.toInt))
}
