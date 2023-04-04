ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"


lazy val root = (project in file("."))
  .settings(
    name := "HelloSpark"
  )

val Version= "3.3.1"
libraryDependencies += "org.apache.spark" %% "spark-core" % Version
libraryDependencies += "org.apache.spark" %% "spark-sql" % Version

