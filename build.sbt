ThisBuild / organization := "io.regadas"
ThisBuild / organizationName := "regadas"
ThisBuild / licenses := Seq(
  "APL2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")
)
ThisBuild / homepage := Some(url("https://github.com/regadas/coursier-apps"))
ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/regadas/coursier-apps"),
    "scm:git@github.com:regadas/cousier-apps.git"
  )
)
ThisBuild / developers := List(
  Developer(
    id = "regadas",
    name = "Filipe Regadas",
    email = "",
    url = url("https://github.com/regadas")
  )
)
ThisBuild / publishMavenStyle := true
ThisBuild / pgpPassphrase := sys.env.get("PGP_PASSPHRASE").map(_.toArray)
ThisBuild / credentials += (for {
  username <- sys.env.get("SONATYPE_USERNAME")
  password <- sys.env.get("SONATYPE_PASSWORD")
} yield Credentials(
  "Sonatype Nexus Repository Manager",
  "oss.sonatype.org",
  username,
  password
))
ThisBuild / dynverSonatypeSnapshots := true
ThisBuild / publishTo := sonatypePublishToBundle.value

publish / skip := true

lazy val apps = project.settings(
  name := "coursier-apps",
  Compile / resourceDirectory := baseDirectory.value / "resources",
  crossPaths := false,
  autoScalaLibrary := false
)
