package common

trait Sorting {
  def sort[A : Ordering](arr: Array[A]): Array[A]
}
