import scala.math.pow

object ArmstrongNumbers {

  def isArmstrongNumber(n: Int): Boolean = {
    val numDigits: Int = (Math.log10(n) + 1).toInt
    var digits = n
    (1 to numDigits).foldLeft(0)((total, _) => {
      val digit = n % 10
      digits = digits / 10
      total + pow(digit, numDigits).toInt
    }) == n
  }
}
