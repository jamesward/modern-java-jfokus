package effects

import zio.{Random, UIO, ZIO, ZIOAppDefault}

import java.io.IOException

object Randoms:

  def r: Int = {
    val seed = java.util.Random()
    seed.nextInt()
  }

  def r2: Int = r * 2

  def rz1: UIO[Int] = {
    Random.nextInt
  }

  def rz2: UIO[Int] = rz1.map(_ * 2)

  val rzv1: UIO[Int] = rz1

  val rzv2: UIO[Int] = rz1.map(_ * 2)
