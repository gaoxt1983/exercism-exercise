class Accumulate {
  def accumulate[A, B](f: (A) => B, list: List[A]): List[B] = {
    list match {
      case ele :: xs => f(ele) :: accumulate(f, xs)
      case Nil => Nil
    }
  }
}
