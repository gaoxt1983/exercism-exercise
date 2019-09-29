object Hamming {

  def distance(sequenceA: String, sequenceB: String): Option[Int] = {
    if (sequenceA.length != sequenceB.length)
      None
    else {
      Option.apply(sequenceA.zip(sequenceB).count {
        case (c1, c2) => c1 != c2
      })
    }
  }
}