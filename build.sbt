ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.2"

val circeVersion = "0.14.5"
val iron         = "2.1.0"

lazy val root = (project in file("."))
  .settings(
    name := "circe-exercises",
    libraryDependencies ++= Seq(
      "io.circe"           %% "circe-core"    % circeVersion,
      "io.circe"           %% "circe-generic" % circeVersion,
      "io.circe"           %% "circe-parser"  % circeVersion,
      "io.github.iltotore" %% "iron"          % iron
    )
  )
