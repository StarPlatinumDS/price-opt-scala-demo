ThisBuild / scalaVersion := "2.13.11"

lazy val root = (project in file("."))
  .settings(
    name := "pricing-optimizer-scala",
    version := "0.1.0",
    libraryDependencies ++= Seq(
      "org.scalanlp" %% "breeze" % "2.1.0",
      "org.knowm.xchart" % "xchart" % "3.8.1",
      "org.scalatest" %% "scalatest" % "3.2.17" % Test
    )
  )
