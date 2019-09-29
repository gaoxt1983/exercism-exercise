object Leap {
  def leapYear(year: Int): Boolean = {
    def _isDivisible(num: Int): Boolean = year % num == 0

    (_isDivisible(4) && !_isDivisible(100)) || _isDivisible(400)
  }
}