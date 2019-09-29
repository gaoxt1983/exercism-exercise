class DNA(seq: String) {
  private[this] final val AVAILABLE_NUC = Set('A', 'C', 'G', 'T')

  def nucleotideCounts(): Either[String, Map[Char, Int]] = {
    val filteredSeq = seq.filter(c => AVAILABLE_NUC.contains(c))
    if (filteredSeq.length < seq.length)
      Left("What ever")
    else
      Right(
        (seq.map(c => (c, 1)) ++ Seq(('A', 0), ('C', 0), ('G', 0), ('T', 0))).
          groupBy(_._1).
          map(e =>
            (e._1, e._2.map((ele: (Char, Int)) => ele._2).sum)
          )
      )
  }
}
