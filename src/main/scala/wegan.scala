import java.io.File
import net.lightbody.bmp.proxy.ProxyServer
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.{DesiredCapabilities,CapabilityType}

object Wegan {
  def usage(): Unit = {
    println("Usage: wegan url output.har")
    println("")
    println("Load the url in chrome and save the performance data as a HAR file.")
  }

  def main(args: Array[String]): Unit = {
    if (args.length != 2) {
      usage()
      return
    }
    val url = args(0)
    val dest = args(1)

    performanceTest(url, dest)
  }

  def performanceTest(url: String, dest:String): Unit = {
    println("Starting proxy server")
    val server = new ProxyServer(9090)
    server.start()

    val proxy = server.seleniumProxy()

    val capabilities = new DesiredCapabilities();
    capabilities.setCapability(CapabilityType.PROXY, proxy)

    println("Starting Chrome driver")
    val driver = new ChromeDriver(capabilities)
    server.newHar("misc-site")

    println("Fetching " + url)
    driver.get(url)

    println("Saving data to " + dest)
    val har = server.getHar()
    har.writeTo(new File(dest))

    println("Closing driver")
    //driver.close()  // XXX hangs
    exit(0)
  }
}

// vim: set ts=2 sw=2 sts=2 et:
