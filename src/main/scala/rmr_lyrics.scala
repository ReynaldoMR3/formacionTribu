import java.text.Normalizer

class palabras {

}

object Lyrics extends App {
  val letra = io.Source.fromFile("src/main/resources/lyrics.txt")
    .getLines()
    .map(_.split(" "))
    .toArray

  val palabraMasRepetida =
    letra.flatMap(
      row => row.map(
        cell => {
          Normalizer.normalize(cell, Normalizer.Form.NFD)
            .replaceAll("[^A-Za-zé|ó|á|í\\s]", "")
            .toLowerCase
        }
      )
    )
      .groupBy(w => {
        w
      }).filter(x => x._2.length > 4)
      .map(
        tupla => {
          (tupla._1, tupla._2.length)
        }
      )
      .maxBy(_._2)

  println(palabraMasRepetida)

}