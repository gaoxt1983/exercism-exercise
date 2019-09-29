object Say {
  def inEnglish(num: Long): String = {
    num.toString.grouped(3).toList.reverse.zipWithIndex.map({
      case (i, group) => {
        if(i==0)

      }
    })
  }

  private[this] def thousandSay(group: String): String = {
    if(group.length == 3)
      s"${group(0)} thou"
  }
}
