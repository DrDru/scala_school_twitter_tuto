//  This is my  first stream test

val my_array = Array[String]("one", "two", "three", "four")

def anotherStream(number: Int, an_array : Array[String]): Stream[String] = Stream.cons(an_array(number % an_array.length), anotherStream(number + 1, an_array))
