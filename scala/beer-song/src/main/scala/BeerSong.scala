object BeerSong {

  val BEERS_MAP: Map[Int, String] = (
    Range(2, 99 + 1).map(e => {
      (
        e,
        s"""${e} ${pluralize(e, "bottle")} of beer on the wall, ${e} ${pluralize(e, "bottle")} of beer.
           |Take one down and pass it around, ${e - 1} ${pluralize(e - 1, "bottle")} of beer on the wall.\n""".stripMargin
      )
    }) ++
      List(
        (1, "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"),
        (0, "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n")
      )
    ).toMap

  def pluralize(i: Int, noun: String): String = {
    if (i > 1) s"${noun}s" else noun
  }

  def recite(numBottle: Int, takeNum: Int): String = {
    val remainNum = if (numBottle < takeNum) -1 else numBottle - takeNum
    Range(numBottle, remainNum, -1).map(e => BEERS_MAP(e)).mkString("\n")

  }
}
