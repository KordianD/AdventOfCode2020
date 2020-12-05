package part2

import scala.io.Source.fromFile

object Main extends App {
  val config = List((1, 1), (3, 1), (5, 1), (7, 1), (1, 2))
  val source = fromFile("src/main/scala/example/data.txt")
  val lines = source.getLines.toList
  source.close()

  def numberOfTrees(right: Int, down: Int): BigInt = {
    lines.zipWithIndex.filter(tuple => tuple._2 % down == 0)
      .count(tuple => tuple._1((tuple._2 / down * right) % tuple._1.length) == '#')
  }

  val result = config.map(tuple => numberOfTrees(tuple._1, tuple._2)).reduce((a, b) => a * b)
  println(result)
}
