package patternmatching

type StringOrBoolean = String | Boolean
type StringAndBoolean = String & Boolean

val a: StringOrBoolean = "asdf"
val b: StringOrBoolean = false

@main
def run1 =
  a match
    case s: String => println(s)
    case b: Boolean => println(b)


enum FooBar:
  case Foo extends FooBar
  case Bar(name: String) extends FooBar

val foo: FooBar = FooBar.Foo

@main
def run2 =
  foo match
    case FooBar.Foo => println("foo")
    case FooBar.Bar(n) => println(n)


val e: Either[String, Boolean] = Left("asdf")

@main
def run3 =
  e match
    case Left(s) => println(s)
    case Right(b) => println(b)
