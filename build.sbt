name := "scala_interview"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies ++= Seq(
//  "com.chuusai" %% "shapeless" % "2.3.3",
  "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  "org.scalacheck" %% "scalacheck" % "1.13.5" % Test
)

// only report failed tests
// see: http://www.scalatest.org/user_guide/using_the_runner
testOptions += Tests.Argument("-oCEXD")

Test / parallelExecution := false

// Run Scalastyle when running tests
lazy val testScalastyle = taskKey[Unit]("")
testScalastyle := (Test / scalastyle).toTask("").value
(Test / test) := ((Test / test) dependsOn testScalastyle).value
