name := "modern-java-jfokus"

scalaVersion := "3.1.2"

val zioVersion = "2.0.0-RC5"

val monocleVersion = "3.1.0"

libraryDependencies ++= Seq(
  "dev.zio" %% "zio"          % zioVersion,
  "dev.zio" %% "zio-test"     % zioVersion,
  "dev.zio" %% "zio-test-sbt" % zioVersion % Test,

  "dev.optics" %%  "monocle-core"  % monocleVersion,
  "dev.optics" %%  "monocle-unsafe"  % monocleVersion,
  "dev.optics" %%  "monocle-macro" % monocleVersion,
)

testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
