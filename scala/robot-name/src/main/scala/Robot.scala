

case class Label(no: String, occupied: Boolean)

object Factory {

  val charRange = Range('A'.toInt, 'Z'.toInt + 1)
  val digitRange = Range('0'.toInt, '9'.toInt + 1)

  implicit val labelOrder: Ordering[Label] = Ordering.by[Label, Boolean](_.occupied)

  var ASSEMBLER: List[Label] = (for {
    firstChar <- charRange
    secondChar <- charRange
    firstDigit <- digitRange
    secondDigit <- digitRange
    thirdDigit <- digitRange
  } yield Label(
    (firstChar.toChar :: secondChar.toChar :: firstDigit.toChar
      :: secondDigit.toChar :: thirdDigit.toChar :: Nil).mkString, occupied = false)).toList
  ASSEMBLER = ASSEMBLER.sorted

  def manifest(): String = {
    val result = ASSEMBLER.head.no
    ASSEMBLER = (ASSEMBLER.head.copy(occupied = true) :: ASSEMBLER.tail).sorted
    result
  }

  def reset(name: String): Unit = {
    val grouped = ASSEMBLER.groupBy(e => e.no == name)
    ASSEMBLER = (grouped(true).map(_.copy(occupied = false)) ++ grouped(false)).sorted
  }
}

class Robot {
  val name: String = Factory.manifest()

  def reset(): Unit = {
    println(name)
    Factory.reset(this.name)
  }
}
