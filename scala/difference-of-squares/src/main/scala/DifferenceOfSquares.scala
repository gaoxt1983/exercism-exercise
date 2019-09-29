object DifferenceOfSquares {

  def sumOfSquares(n: Int): Int = {
    Range(1, n + 1).map(e => e * e).sum
  }

  def squareOfSum(n: Int): Int = {
    val sum = Range(1, n + 1).sum
    sum * sum
  }

  def differenceOfSquares(n: Int): Int = {
    squareOfSum(n) - sumOfSquares(n)
  }
}
