package example

import scala.io.Source.fromFile

object Main extends App {
  val source = fromFile("src/main/scala/example/data.txt")

  val result = source.getLines.zipWithIndex.count(tuple => tuple._1((tuple._2 * 3) % tuple._1.size) == '#')

  println(result)

  source.close
}
