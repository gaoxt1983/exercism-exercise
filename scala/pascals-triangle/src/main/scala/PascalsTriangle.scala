object PascalsTriangle {

  def rows(num: Int): List[List[Int]] = {
    (1 to num).foldLeft(List[List[Int]]())((accum, n) => {
      if (n == 1)
        accum ++ List(List(1))
      else {
        accum ++ List(0.until(n).map(e => {
          val previous = accum(n - 2)
          val left = if (e - 1 < 0) 0 else previous(e - 1)
          val right = if (e > n) 0 else previous(e)
          left + right
        }).toList)
      }
    })
  }
}
