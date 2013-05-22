#
#  Makefile
#  wegan
#

target/scala-2.10/wegan_2.10-1.0-one-jar.jar: src/main/scala/wegan.scala
	sbt one-jar
