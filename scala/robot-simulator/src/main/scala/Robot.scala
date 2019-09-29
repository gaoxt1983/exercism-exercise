object Bearing extends Enumeration {
  type Bearing = Value
  val North, East, South, West = Value
}

case class Robot(bearing: Bearing.Value, coordinates: (Int, Int)) {

  def turnRight(): Robot = {
    val newBearing =
      if (this.bearing == Bearing.West) {
        Bearing.North
      } else {
        Bearing(this.bearing.id + 1)
      }
    this.copy(bearing = newBearing)
  }

  def turnLeft(): Robot = {
    val newBearing =
      if (this.bearing == Bearing.North) {
        Bearing.West
      } else {
        Bearing(this.bearing.id - 1)
      }
    this.copy(bearing = newBearing)
  }

  def advance(): Robot = {
    this.bearing match {
      case Bearing.North => this.copy(coordinates = (this.coordinates._1, this.coordinates._2 + 1))
      case Bearing.West => this.copy(coordinates = (this.coordinates._1 - 1, this.coordinates._2))
      case Bearing.East => this.copy(coordinates = (this.coordinates._1 + 1, this.coordinates._2))
      case Bearing.South => this.copy(coordinates = (this.coordinates._1, this.coordinates._2 - 1))
    }
  }

  def simulate(seq: String): Robot = {
    seq.foldLeft(this)({
      case (robot, instruct) =>
        instruct match {
          case 'R' => robot.turnRight()
          case 'L' => robot.turnLeft()
          case 'A' => robot.advance()
        }
    })
  }
}