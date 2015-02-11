name := "xDlink-server"

version := "2.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "ws.securesocial" %% "securesocial" % "2.1.4"
)     

play.Project.playJavaSettings
