name := "interview"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies ++= Seq(
  "com.chuusai" %% "shapeless" % "2.3.3",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)

// only report failed tests
// see: http://www.scalatest.org/user_guide/using_the_runner
testOptions += Tests.Argument("-oCEXD")

Test / parallelExecution := false