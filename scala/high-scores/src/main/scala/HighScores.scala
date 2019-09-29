object HighScores {

  def latest(scores: List[Int]): Int = {
    scores.last
  }

  def personalBest(scores: List[Int]): Int = {
    scores.max
  }

  def personalTop(scores: List[Int]): List[Int] = {
    scores.sorted.reverse.take(3)
  }

  def report(scores: List[Int]): String = {
    val l = latest(scores)
    val diff = personalBest(scores) - l
    if (diff == 0)
      s"Your latest score was $l. That's your personal best!"
    else
      s"Your latest score was $l. That's $diff short of your personal best!"
  }
}
