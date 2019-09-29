

object Bob {

  def response(statement: String): String = {
    val trimedStatement = statement.trim
    if (trimedStatement.isEmpty)
      "Fine. Be that way!"
    else if (isYelling(trimedStatement)) {
      if (trimedStatement.endsWith("?"))
        "Calm down, I know what I'm doing!"
      else
        "Whoa, chill out!"
    } else if (trimedStatement.endsWith("?")) {
      "Sure."
    } else {
      "Whatever."
    }
  }

  private[this] def isYelling(statement: String): Boolean = {
    val letters = statement.filter(c => c.isLetter)
    if (letters.isEmpty)
      false
    else
      letters.forall(c => c.isUpper)
  }
}
