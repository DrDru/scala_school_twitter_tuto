import scala.language.implicitConversions

implicit def strToInt(x: String) = x.toInt

"123" // this is a string

val y: Int = "123" //this is an Int

math.max("123", 111) // this works because "123" is implicitly converted to Int 


//This says that A has to be “viewable” as Int. Let’s try it. ...
class Container[A <% Int] { def addIt(x: A) = 123 + x }

(new Container[String]).addIt("123") // Work thanks to the code above

(new Container[Int]).addIt(123) // Works


// Does not work
//(new Container[Float]).addIt(123.2F)

/ Wow
sum[B >: A](implicit num: Numeric[B]): B

// A must be equal to Int. 
// Why then not use A: Int ?
class Container[A](value: A) { def addIt(implicit evidence: A =:= Int) = 123 + value }
(new Container(123)).addIt

// Does not work since 123 is not of type Int
//(new Container("123")).addIt


// Views are used for generics
// This is Scala min function
def min[B >: A](implicit cmp: Ordering[B]): A = {
  if (isEmpty)
    throw new UnsupportedOperationException("empty.min")

  reduceLeft((x, y) => if (cmp.lteq(x, y)) x else y)
}
