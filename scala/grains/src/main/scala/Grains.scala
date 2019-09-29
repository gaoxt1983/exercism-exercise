import math.pow

object Grains {

  def square(n: Int): Option[BigInt] = {
    if (n > 64 || n <= 0)
      None
    else
      Option.apply(_square(n))
  }

  def _square(n: Int): BigInt = {
    1.until(n).map(_ => BigInt(2)).fold(BigInt(1))((a, b) => a * b)
  }

  def total: BigInt = {
    1.until(64).map(_square).sum
  }
}
