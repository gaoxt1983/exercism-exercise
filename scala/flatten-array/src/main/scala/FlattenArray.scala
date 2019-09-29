object FlattenArray {

  def flatten(list: List[Any]): List[Int] = {
    list match {
      case ele :: xs =>
        val eleMatched = ele match {
          case ints: List[Int] => flatten(ints)
          case null => List()
          case _ => List(ele.asInstanceOf[Int])
        }
        eleMatched ++ flatten(xs)
      case Nil => List()
    }

  }
}
