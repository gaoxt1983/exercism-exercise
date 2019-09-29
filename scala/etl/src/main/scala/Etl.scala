object Etl {
  def transform(scores: Map[Int, Seq[String]]): Map[String, Int] = {
    scores.flatMap({
      case (k, values) => values.map(v => (v.toLowerCase(), k))
    })
  }
}