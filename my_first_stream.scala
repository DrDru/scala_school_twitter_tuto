//  This is my  first stream

val my_array = Array[String]("one", "two", "three", "four")

def anotherStream(number: Int, an_array : Array[String]): Stream[String] = Stream.cons(an_array(number), anotherStream(number + 1, an_array))
