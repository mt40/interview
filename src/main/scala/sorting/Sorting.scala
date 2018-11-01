package sorting

trait Sorting {
  def sort[A : Ordering](arr: Array[A]): Seq[A]
}
