object SecretHandshake {
  private[this] val COMMANDS: List[(Int, String)] = List(
    1 -> "wink",
    2 -> "double blink",
    4 -> "close your eyes",
    8 -> "jump"
  )

  private[this] val REVERSE_COMMAND = 16

  def commands(n: Int): List[String] = {
    val result = COMMANDS.flatMap(c => if ((n & c._1) != 0) Option.apply(c._2) else None)
    if ((n & REVERSE_COMMAND) != 0)
      result.reverse
    else
      result
  }
}