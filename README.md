# Wegan

From Old Saxon: "to weigh, consider"

A simple Scala wrapper for Selenium with ChromeDriver which fetches a page in Chrome and dumps a HAR file describing its performance.

### Dependencies

You should install and put into your PATH:

- [ChromeDriver](https://code.google.com/p/selenium/wiki/ChromeDriver)
- [sbt](http://www.scala-sbt.org/)

### Building

Run `make`.

### Running

Wegan takes a url and the output HAR file as command-line parameters. For example:

`./bin/wegan http://google.com/ output.har`
