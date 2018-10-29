package common

import shapeless.{Generic, HList}

/** Evidence that `A` can be parsed from `Array[String]`. */
trait Parseable[A] {

  /**
    * Parse a list of arguments.
    * @param args arguments. For example, a list and a number:
    *             ["1 2 3", "5"]
    */
  def parse(args: Iterator[String]): A

  def and[B](p: Parseable[B]): Parseable[(A, B)] = {
    Parseable.instance { args =>
      val a = this.parse(args)
      val b = p.parse(args)
      (a, b)
    }
  }

  def map[B](f: A => B): Parseable[B] =
    Parseable.instance(args => f(this.parse(args)))
}

object Parseable extends Instances {
  // TODO: always flatten tuple
  implicit def tuple2CaseClass[A, B <: Product, Repr <: HList](
    p: Parseable[A]
  )(implicit
    ga: Generic.Aux[A, Repr],
    gb: Generic.Aux[B, Repr]
  ): Parseable[B] = {
    p.map(a => gb.from(ga.to(a)))
  }
}

trait Instances {

  def instance[A](f: Iterator[String] => A): Parseable[A] = {
    new Parseable[A] {
      override def parse(args: Iterator[String]): A = f(args)
    }
  }

  implicit def int: Parseable[Int] =
    instance(_.next.toInt)

  implicit def intArray: Parseable[Array[Int]] =
    instance(_.next.split(' ').map(_.toInt))
}
