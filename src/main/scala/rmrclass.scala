object csvRead extends App {
  val csvFile = io.Source.fromFile("src/main/resources/RealEstate.csv")
    .getLines()
    .drop(1)
    .map(_.split(","))
    .toArray

  val bedroom = csvFile.filter(x => x(3) matches "\\d")

  val bedroom_size = bedroom.map(row => {
    row(3).toInt match{
      case 1 => "chico"
      case 2 => "mediano"
      case 3 => "grande"
      case 4 => "familiar"
      case _ =>
    }
  })

  bedroom_size.foreach(
    println(_)
  )
}