case class Triangle(a: Double, b: Double, c: Double) {

  private[this] final val EDGE_CROSS_PRODUCT = crossProduct

  private[this] def crossProduct: Seq[(Double, Double)] = {
    val seq = Seq(a, b, c).zipWithIndex
    seq.flatMap(x => seq.map(y => (x, y)).filter(e => e._1 != e._2)).map(e => (e._1._1, e._2._1))
  }

  def isosceles: Boolean = {
    isValid && EDGE_CROSS_PRODUCT.foldLeft(false)(
      (result, ele) => result || ele._1 == ele._2)
  }

  def equilateral: Boolean = {
    isValid && EDGE_CROSS_PRODUCT.foldLeft(true)((result, ele) => result && ele._1 == ele._2)
  }

  def scalene: Boolean = {
    isValid && EDGE_CROSS_PRODUCT.foldLeft(true)((result, ele) => result && ele._1 != ele._2)
  }

  def isValid: Boolean = {
    val nonZero = EDGE_CROSS_PRODUCT.map(e => e._1 != 0 && e._2 != 0).reduce((a, b) => a && b)
    if (!nonZero)
      false
    else if (!EDGE_CROSS_PRODUCT.map(e => {
      val sum = e._1 + e._2
      if (sum < a || sum < b || sum < c)
        false
      else
        true
    }).reduce((a, b) => a && b))
      false
    else
      true
  }
}
