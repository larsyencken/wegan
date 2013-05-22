seq(com.github.retronym.SbtOneJar.oneJarSettings: _*)

name := "wegan"

version := "1.0"

scalaVersion := "2.10.1"

libraryDependencies += "org.seleniumhq.selenium" % "selenium-java" % "2.32.0"

libraryDependencies += "net.lightbody.bmp" % "browsermob-proxy" % "2.0-beta-8"
