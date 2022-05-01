package effects


import zio.test.*
import zio.test.Assertion.*
import zio.test.Assertion.Render.*

import java.io.IOException

object RandomsSpec extends ZIOSpecDefault:
  def spec = suite("random") {
    test("times two") {
      for
        _ <- TestRandom.feedInts(1)
        output <- Randoms.rz2
      yield
        assert(output)(equalTo(2))
    }
  }