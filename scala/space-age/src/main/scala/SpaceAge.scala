import scala.language.dynamics

// Wow, scala version's method missing
object SpaceAge extends Dynamic {

  final val PLANET_COEFFICIENT = Map(
    "Mercury" -> 0.2408467,
    "Venus" -> 0.61519726,
    "Mars" -> 1.8808158,
    "Jupiter" -> 11.862615,
    "Saturn" -> 29.447498,
    "Uranus" -> 84.016846,
    "Neptune" -> 164.79132,
    "Earth" -> 1.0
  )

  final val EARTH_SECONDS = 31557600L

  def applyDynamic(name: String)(seconds: Double): Double = {
    val planetName = name.replace("on", "")
    val coefficient = PLANET_COEFFICIENT(planetName)
    seconds / (EARTH_SECONDS * coefficient)
  }
}