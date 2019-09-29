object NumberType {
  val Perfect = 0
  val Abundant = 1
  val Deficient = 2
}

object PerfectNumbers {

  def classify(num: Int): Either[String, Int] = {
    if (num <= 0)
      Left("Classification is only possible for natural numbers.")
    else
      Right(
        Range(1, num).filter(num % _ == 0).sum.compareTo(num) match {
          case 0 => NumberType.Perfect
          case 1 => NumberType.Abundant
          case -1 => NumberType.Deficient
        }
      )

  }
}
