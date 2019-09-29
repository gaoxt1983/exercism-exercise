import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.{ChronoUnit, TemporalAdjuster}

object Gigasecond {
  private val GIGASECONDS: Long = 1000000000L

  def add(startDate: LocalDate): LocalDateTime = {
    startDate.atStartOfDay().plus(GIGASECONDS, ChronoUnit.SECONDS)
  }

  def add(startDateTime: LocalDateTime): LocalDateTime = {
    startDateTime.plus(GIGASECONDS, ChronoUnit.SECONDS)
  }
}
