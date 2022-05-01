package effects

import zio.{Console, ZIO, ZIOAppDefault}

import java.io.IOException

object Hello extends ZIOAppDefault:

  val app =
    Console.printLine("hello, world")

  def run =
    app
