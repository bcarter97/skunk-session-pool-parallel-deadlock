val scala3Version = "3.3.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "skunk-session-pool-parallel-deadlock",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.tpolecat" %% "skunk-core" % "1.1.0-M3",

    run / fork := true
  )
