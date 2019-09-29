
// Shameless copy from @rdblyth
object MatchingBrackets {

  private val BRACKETS_MAP = Map(
    '}' -> '{',
    ']' -> '[',
    ')' -> '('
  )

  def isPaired(expression: String, stack: List[Char] = List[Char]()): Boolean = {
    @scala.annotation.tailrec
    def isMatched(chars: List[Char], stack: List[Char]): Boolean = {
      (chars, stack) match {
        case (list@('{' | '[' | '(') :: xs, stack) => isMatched(xs, list.head +: stack)
        case (list@('}' | ']' | ')') :: _, stack) =>
          stack.nonEmpty && stack.head == BRACKETS_MAP(list.head) && isMatched(list.tail, stack.tail)
        case (_ :: xs, stack) => isMatched(xs, stack)
        case (Nil, Nil) => true
        case (Nil, _ :: _) => false
      }
    }

    isMatched(expression.toList, List())
  }
}
