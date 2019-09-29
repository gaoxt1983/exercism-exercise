object CollatzConjecture {

  def steps(n: Int): Option[Int] = {
    if (n <= 0)
      None
    else
      Option(Stream.iterate(n)(next).takeWhile(i => i != 1).length)
  }

  def next(n: Int): Int = {
    if (n % 2 == 0)
      n / 2
    else
      n * 3 + 1
  }
}
