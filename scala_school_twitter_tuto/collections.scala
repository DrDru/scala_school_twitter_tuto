val a_tuple = ("a string", 1, 6.5)

a_tuple._1
a_tuple._2

// Syntactic to create a pair
1 -> 2

// Key value pairs
val map1 = Map(1 -> 2, 2->3, "three" -> 2)
val map2 = Map("foo" -> "bar")

map1(1)
map1("three")

// Options

trait Option[T] {
  def isDefined: Boolean
  def get: T
  def getOrElse(t: T): T
}

// Map.get uses Option for its return type. 
val numbers = Map("one" -> 1, "two" -> 2)
val result1 = numbers.get("two")
numbers.get("three")

// To get the returned argument with its own type (vs type option) use getOrElse 
val result = result1.getOrElse(0) * 2

val result2 = result1 match {
  case Some(n) => n * 2
  case None => 0
}

// map
val numbers = List(1, 2, 3, 4)
numbers.map((i: Int) => i * 2)

def timesTwo(i: Int): Int = i * 2
numbers.map(timesTwo)

// for each 
// like map but returns Unit ; used for side effects only
numbers.foreach((i: Int) => i * 2)
val doubled = numbers.foreach((i: Int) => i * 2)

// filter
numbers.filter((i: Int) => i % 2 == 0)

def isEven(i: Int): Boolean = i % 2 == 0
numbers.filter(isEven)


// zip
List(1, 2, 3).zip(List("a", "b", "c"))

// partition
// partition splits a list based on where it falls 
// with respect to a predicate function.

val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
numbers.partition(_ % 2 == 0)

// find
// find returns the first element of a collection
// that matches a predicate function.
numbers.find((i: Int) => i > 5)
numbers.find((i: Int) => i > 5).getOrElse(1)

// drop
// drops the first i elements (from 1st to 5th)
numbers.drop(5)

// same 
// keeps dropping till it goes into an odd number
numbers.dropWhile(_ % 2 != 0)

// fold left

// applies sum 1 by 1 starting fro, the left
numbers.foldLeft(0) { (m: Int, n: Int) => println("m: " + m + " n: " + n); m + n }
numbers.foldRight(0) { (m: Int, n: Int) => println("m: " + m + " n: " + n); m + n }

// flatten 
List(List(1, 2), List(3, 4)).flatten

// flatMap 
// applies map and flatten the result
val nestedNumbers = List(List(1, 2), List(3, 4))
nestedNumbers.flatMap(x => x.map(_ * 2))

// equivalent to 

nestedNumbers.map((x: List[Int]) => x.map(_ * 2)).flatten


// Create our own map function
// Start from the rightmost element apply the 'fn' function 
// and append the right tail of the list
def ourMap(numbers: List[Int], fn: Int => Int): List[Int] = {
  numbers.foldRight(List[Int]()) { (x: Int, xs: List[Int]) =>
    fn(x) :: xs
  }
}

// eg
// List(1, 2, 3, 4)
// n = x^2
// 1 - List(1, 2, 3, 16) 
// 2 - List(1, 2, 9, 16)
// ... 

// All the functions shown below work on map as well
val extensions = Map("steve" -> 100, "bob" -> 101, "joe" -> 201)
extensions.filter((namePhone: (String, Int)) => namePhone._2 < 200)






