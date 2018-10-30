package common

abstract class Question[In : Parser, Out] {

  def main(args: Array[String]): Unit = {
    runMain(args)
  }

  /**
    * Replace `main` because this can return a specific type.
    * Typically used by tests.
    */
  final def runMain(args: Array[String]): Out = {
    run(implicitly[Parser[In]].parse(args.iterator))
  }

  def run(input: In): Out
}
