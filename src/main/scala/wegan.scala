import java.io.File
import net.lightbody.bmp.proxy.ProxyServer
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.{DesiredCapabilities,CapabilityType}

object Wegan {
  def main(args: Array[String]) = {
    val server = new ProxyServer(9090)
    server.start()

    val proxy = server.seleniumProxy()

    val capabilities = new DesiredCapabilities();
    capabilities.setCapability(CapabilityType.PROXY, proxy)

    val driver = new ChromeDriver(capabilities)
    server.newHar("99designs.com")

    driver.get("http://99designs.com.au")

    val har = server.getHar()
    har.writeTo(new File("99designs-com.har"));
    driver.close
  }
}

// vim: set ts=2 sw=2 sts=2 et:
