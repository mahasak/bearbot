name := "bearbot"

organization := "io.bigbears"

version := "1.0"

sources in(Compile, doc) := Seq.empty

publishArtifact in(Compile, packageDoc) := false

packageName in Universal := "release"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

scalacOptions += "-feature"

scalacOptions += "-deprecation"

routesGenerator := InjectedRoutesGenerator

libraryDependencies ++= Seq(
  jdbc
    exclude("com.h2database", "h2")
    exclude("com.jolbox", "bonecp")
  , cache
  , "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.7.2"
  , "com.typesafe.scala-logging" %% "scala-logging" % "3.4.0"
  , "org.postgresql" % "postgresql" % "9.4.1208"
  , "org.jbehave" % "jbehave-core" % "4.0.5"
  , "net.codingwell" %% "scala-guice" % "4.1.0"
  , "org.mindrot" % "jbcrypt" % "0.3m"
  , "org.postgresql" % "postgresql" % "9.4.1208"
)

libraryDependencies ++= Seq(
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % "test",
  "org.scalaj" %% "scalaj-http" % "2.3.0"
)

parallelExecution in Test := true
