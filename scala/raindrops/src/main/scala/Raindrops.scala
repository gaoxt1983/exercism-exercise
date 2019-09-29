object Raindrops {
  private[this] val DROP_FACTORS = Map(
    3 -> "Pling",
    5 -> "Plang",
    7 -> "Plong"
  )

  def convert(n: Int): String = {
    val sentence = DROP_FACTORS.filter({
      case (k, _) => n % k == 0
    }).map({
      case (_, sentence) => sentence
    }).mkString("")
    if (sentence.isEmpty)
      n.toString
    else
      sentence
  }
}

