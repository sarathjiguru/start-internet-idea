name := "appstackserver"

version := "1.0"

lazy val `appstackserver` = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(javaEbean , cache , javaWs,
  "com.datastax.cassandra" % "cassandra-driver-core" % "2.1.6")

play.PlayJava.projectSettings

resolvers += "maven" at "http://central.maven.org/maven2"

resolvers += "Kundera missing" at "http://kundera.googlecode.com/svn/maven2/maven-missing-resources"

resolvers += "Scale 7" at "https://github.com/s7/mvnrepo/raw/master"

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )