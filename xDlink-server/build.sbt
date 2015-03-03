name := "xDlink-server"

version := "2.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "ws.securesocial" %% "securesocial" % "2.1.4",
  "mysql" % "mysql-connector-java" % "5.1.18"
)


libraryDependencies += "org.dbunit" % "dbunit" % "2.5.0"

play.Project.playJavaSettings
