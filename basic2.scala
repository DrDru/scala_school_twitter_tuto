// Apply method
class Foo {}

object FooMaker {
    def apply() = { new Foo ; println("Hello world")}
}
	  
val newFoo = FooMaker()
	 
// Objects vs classes
// Object	 
class Bar(foo: String)

object Bar {
  def apply(foo: String) = new Bar(foo)
}
// Class	 
class BarClass(foo: String) {
  def apply(foo: String) = new BarClass(foo)
}

// You can create several BarClasses
var a = new BarClass("test_string")
println(a)

// You can create several Bars
var b = new Bar("test_string2")
var c = new Bar("test_string3")
println(b)
println(c)

// Bar is instantiated and can not be duplicated
println(Bar)

// Function are litterally objects :
// instances of a class that you can not duplicate
object addOne extends Function1[Int, Int] {
        def apply(m: Int): Int = m + 1
}

addOne(1)

// This does not work. Only 1 (+1) arguments are given. At least 2 (+1) required
// object addOneBreak extends Function3[Int, Int] {
//         def apply(m: Int): Int = m + 1
// }
// addOneBreak(1)

// Function 2 takes 2(+ 1) arguments 
object addOneWorks extends Function2[Int, Int, Int] {
    def apply(m: Int, n : Int): Int = m + n
}
addOneWorks(1,2)

// This is a class
class AddOne extends Function1[Int, Int] {
    def apply(m: Int): Int = m + 1
}

val plusOne = new AddOne()  // This is a function

plusOne(1)

class AddOne extends (Int => Int) {
  def apply(m: Int): Int = m + 1
}


// Pattern matching
val times = 1

// I did not manage to use pattern matching without wrapping the match into a function
def test(example : Any): Unit = {

	example match {
		case i: Int => println("Int")
		case j: String => println("String")
		case  _ => println("some other type")
	}	
}

test(times)

// Matching on class members 
// Don't do this
def calcType(calc: Calculator) = calc match {
  case _ if calc.brand == "HP" && calc.model == "20B" => "financial"
  case _ if calc.brand == "HP" && calc.model == "48G" => "scientific"
  case _ if calc.brand == "HP" && calc.model == "30B" => "business"
  case _ => "unknown"
}

// but rather
/*
def calcType(calc: Calculator) = calc match {
  case Calculator("HP", "20B") => "financial"
  case Calculator("HP", "48G") => "scientific"
  case Calculator("HP", "30B") => "business"
  case Calculator(ourBrand, ourModel) => "Calculator: %s %s is of unknown type".format(ourBrand, ourModel)
}
*/

// Exceptions
/*
try {
  remoteCalculatorService.add(1, 2)
} catch {
  case e: ServerIsDownException => log.error(e, "the remote calculator service is unavailable. should have kept your trusty HP.")
} finally {
  remoteCalculatorService.close()
}
*/
// The result can be stored 
/*
val result: Int = try {
  remoteCalculatorService.add(1, 2)
} catch {
  case e: ServerIsDownException => {
    log.error(e, "the remote calculator service is unavailable. should have kept your trusty HP.")
    0
  }
} finally {
  remoteCalculatorService.close()
}
*/