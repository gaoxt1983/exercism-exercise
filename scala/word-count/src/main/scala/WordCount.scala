case class WordCount(sentence: String) {
  private[this] final val PUNCS = ":\n!&@$%^&."

  def countWords(): Map[String, Int] = {
    sentence.trim().filter(c => !PUNCS.contains(c)).split("\\s+|,\\s*").map(word => {
      val normalizedWord =
        if (word.startsWith("'") && word.endsWith("'"))
          word.substring(1, word.length - 1)
        else
          word
      (normalizedWord.toLowerCase(), 1)
    }).
      groupBy(_._1).
      map(e => (e._1,
        e._2.map(ele => ele._2).sum
      ))
  }
}