object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int = {
    factors.flatMap(e => {
      for {
        i <- Range(1, limit + 1)
        candi = e * i
        if (candi < limit)
      } yield candi
    }).sum
  }
}

