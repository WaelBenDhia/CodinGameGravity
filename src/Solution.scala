/**
  * Created by wael on 10/30/16.
  */

object Solution extends App {
  val Array(width, height) = for(i <- readLine split " ") yield i.toInt
  val map : Array[Array[Char]] = new Array[Array[Char]](height)
  for(i <- 0 until height) {
    map(i) = readLine.toArray
  }

  for(x <- 0 until width){
    var dropHeight = 0
    for(y <- height-1 to 0 by -1){
      if(map(y)(x) == '.')
        dropHeight += 1
      if(map(y)(x) == '#' && dropHeight != 0) {
        map(y)(x) = '.'
        map(y+dropHeight)(x) = '#'
      }
    }
  }

  println({
    val ret : StringBuilder = new StringBuilder
    for(i <- 0 until height){
      for(j <- 0 until width)
        ret += map(i)(j)
      if(i != height - 1) ret += '\n'
    }
    ret.toString()
  })
}
