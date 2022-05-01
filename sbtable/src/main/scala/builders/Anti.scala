package builders

case class Foo(bars: List[String])

case class Anti(foo: Foo)

@main
def run =
  val a = Anti(Foo(List("asdf", "zxzv")))
  println(a)