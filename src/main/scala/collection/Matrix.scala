package collection

class Matrix[A] private (private val data: Seq[Seq[A]]) {

  def rows: Int = data.length

  def cols: Int = data.headOption.map(_.length).getOrElse(0)

  /**
    * Matrix multiplication.
    * Time: O(n + m) where n & m are number of elements in each matrix
    */
  def times(other: Matrix[A])(implicit num: Numeric[A]): Matrix[A] = {
    if (cols != other.rows) {
      throw new UnsupportedOperationException(s"can only multiply with $cols-row matrix")
    }
    else {
      val newData: Seq[A] = for {
        r <- data
        c <- other.data.transpose
      } yield {
        r.zip(c).map(rc => num.times(rc._1, rc._2)).reduce(num.plus)
      }
      Matrix(rows, other.cols, newData)
    }
  }

  override def toString: String = {
    data.map(_.mkString(" ")).mkString("\n")
  }

  override def hashCode(): Int = (rows, cols, data).hashCode()

  override def equals(obj: Any): Boolean = {
    obj match {
      case mat: Matrix[A] =>
        rows == mat.rows && cols == mat.cols && data == mat.data
      case _ => false
    }
  }
}

object Matrix {

  def apply[A](rows: Int, cols: Int, default: A): Matrix[A] = {
    new Matrix(Vector.fill(rows, cols)(default))
  }

  def apply[A](rows: Int, cols: Int, values: Seq[A]): Matrix[A] = {
    val data = values
      .sliding(cols, step = cols)
      .foldLeft(Vector.empty[Vector[A]])((data, row) => data :+ row.toVector)
    new Matrix[A](data)
  }
}
