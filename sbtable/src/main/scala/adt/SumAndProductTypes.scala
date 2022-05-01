package adt

type StringOrBoolean = String | Boolean
type StringAndBoolean = String & Boolean

val a: StringOrBoolean = "asdf"
val b: StringOrBoolean = false


enum FooBar:
  case Foo extends FooBar
  case Bar(name: String) extends FooBar

val foo: FooBar = FooBar.Foo


val e: Either[String, Boolean] = Left("asdf")


case class Bar(name: String)
val bar = Bar("asdf")