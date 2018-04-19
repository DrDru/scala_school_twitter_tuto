// To read this file
// :lo basic.scala  

// Anonymous functions
(x: Int) => x + 1

val one = Seq(1,2,3)

one.map(x => x + 1)

def adder(m: Int, n: Int) = m + n

val addTwo = adder(2, _:Int)
addTwo(3)

def multiply(m: Int)(n: Int): Int = m * n

multiply(2)(3)

def adder3(m: Int, n: Int, o: Int) = m + n + o 

val adder3Curried = (adder3 _).curried
adder3Curried(1)(2)(3)

def capitalizeAll(args: String*) = {
  args.map { arg =>
    arg.capitalize
  }
}

// You can pass a list but not a List !
// val mylist = List("rarity", "applejack")

capitalizeAll("rarity", "applejack", "ppop")

class Calculator {

	val brand: String = "HP"
	val number: Int = 123456 
	def add(m: Int, n: Int): Int = m + n

}

val calc = new Calculator

calc.add(1, 2)


class Calculator(brand: String) {
  /**
   * A constructor.
   */
  val color: String = if (brand == "TI") {
    "blue"
  } else if (brand == "HP") {
    "black"
  } else {
    "white"
  }

  // An instance method.
  def add(m: Int, n: Int): Int = m + n
}

val calc = new Calculator("HP")
calc.color 

val calc2 = new Calculator("TI")
calc2.color 


class ScientificCalculator(brand: String) extends Calculator(brand) {
  def log(m: Double, base: Double) = math.log(m) / math.log(base)
  
  def square(m: Double) = m * m
}

val newDevice = new ScientificCalculator("TI")

newDevice.square(7)

class EvenMoreScientificCalculator(brand: String) extends ScientificCalculator(brand) {

  def log(m: Int): Double = log(m, math.exp(1))
  
  override def square(m: Double): Double =  m * m + 1 

}


val newDevice2 = new EvenMoreScientificCalculator("TI")

newDevice2.square(7)  // Should return 50

abstract class Eater {
	
	def eat(): Unit
	
}

class Dog() extends Eater {

	def eat(): Unit = println("I am a dog eater")

}

val rex = new Dog

rex.eat()


trait Car {
  val brand: String
}

trait Shiny {
  val shineRefraction: Int
}

class BMW extends Car {
  val brand = "BMW"
}


class BMW extends Car with Shiny {
  val brand = "BMW"
  val shineRefraction = 12
}