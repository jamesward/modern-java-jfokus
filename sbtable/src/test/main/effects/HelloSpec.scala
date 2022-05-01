package effects

import zio.test.*
import zio.test.Assertion.*
import zio.test.Assertion.Render.*

import java.io.IOException

object HelloSpec extends ZIOSpecDefault:
  def spec = suite("hello") {
    test("hello") {
      for
        _ <- Hello.app
        output <- TestConsole.output
      yield
        assert(output.head)(equalTo("hello, world\n"))
    }
  }
