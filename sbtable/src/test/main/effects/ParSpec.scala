package effects


import zio.*
import zio.test.*
import zio.test.Assertion.*
import zio.test.Assertion.Render.*

import java.io.IOException

object ParSpec extends ZIOSpecDefault:
  def spec = suite("par")(
    test("it takes time") {
      for
        _ <- sleepThenPrint(3.seconds).fork
        output <- TestConsole.output
      yield
        assert(output.isEmpty)(isTrue)
    },
    test("time travel") {
      for
        f <- sleepThenPrint(3.seconds).fork
        _ <- TestClock.adjust(3.seconds)
        _ <- f.join
        output <- TestConsole.output
      yield
        assert(output.head)(equalTo("3 s elapsed\n"))
    },
  )