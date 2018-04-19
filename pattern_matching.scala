// Function composition
def f(s: String) = "f(" + s + ")"
def g(s: String) = "g(" + s + ")"

val fComposeG = f _ compose g _
fComposeG("yay")

// Same as compose but in reverse order
val fAndThenG = f _ andThen g _
fAndThenG("yay")

// Partial functions != partially applied functions

val one: PartialFunction[Int, String] = { case 1 => "one" }
one.isDefinedAt(1)
one.isDefinedAt(2)

one(1)

val two: PartialFunction[Int, String] = { case 2 => "two" }
val three: PartialFunction[Int, String] = { case 3 => "three" }
val wildcard: PartialFunction[Int, String] = { case _ => "something else" }

val partial = one orElse two orElse three orElse wildcard

partial(5)
partial(3)
partial(2)
partial(1)
partial(0)

