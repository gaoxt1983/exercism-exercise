import scala.collection.SortedMap

class School {
  type DB = Map[Int, Seq[String]]

  private[this] var grades: SortedMap[Int, Seq[String]] = SortedMap[Int, Seq[String]]()

  def add(name: String, g: Int) = {
    val x: (Int, Seq[String]) = (g, (grades.getOrElse(g, Seq[String]()) ++ Seq(name)))
    grades = grades + x
  }

  def db: DB = grades.toMap

  def grade(g: Int): Seq[String] = {
    db.getOrElse(g, Seq[String]())
  }

  def sorted: DB = {
    grades.map(e => (e._1, e._2.sorted)).toMap
  }
}
