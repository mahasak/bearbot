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
  , "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.8.3"
  , "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0"
  , "de.svenkubiak" % "jBCrypt" % "0.4.1"
  , "org.postgresql" % "postgresql" % "9.4.1208"
  , "org.jbehave" % "jbehave-core" % "4.0.5"
  , "net.codingwell" %% "scala-guice" % "4.1.0"
  , "org.postgresql" % "postgresql" % "9.4.1208"
  , "org.scalaj" %% "scalaj-http" % "2.3.0"
)

libraryDependencies ++= Seq(
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % "test"
)

excludeDependencies ++= Seq(
  SbtExclusionRule("com.typesafe.play", "play-java")
  , SbtExclusionRule("com.typesafe.play", "play-json")
)

resolvers += Resolver.sonatypeRepo("releases")
resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

mappings in Universal := {
  val origMappings = (mappings in Universal).value
  origMappings.filterNot { case (_, file) => file.endsWith("logback.xml") }
}

parallelExecution := true
parallelExecution in Test := true
