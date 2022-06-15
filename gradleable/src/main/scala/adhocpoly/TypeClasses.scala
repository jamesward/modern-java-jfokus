package adhocpoly

trait ToChar[T]:
  def toChar(t: T): Char

extension [T: ToChar] (i: Iterable[T]) def sumT(): Int = {
  val f = summon[ToChar[T]].toChar
  i.foldLeft(0) { (acc: Int, t: T) =>
    acc + f(t).intValue
  }
}

@main
def run =
  given ToChar[Char] with
    def toChar(t: Char): Char = t

  println(Seq('a', 'b', 'c').sumT())

  given ToChar[String] with
    def toChar(t: String): Char = t.toCharArray.head

  println(Seq("a", "b").sumT())

  given seqToChar[T: ToChar]: ToChar[Seq[T]] with
    def toChar(s: Seq[T]): Char = summon[ToChar[T]].toChar(s.head)

  println(Seq(Seq('a', 'b'), Seq('c')).sumT())
