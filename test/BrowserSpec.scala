import org.scalatestplus.play._
import org.scalatestplus.play.guice.GuiceOneServerPerTest

/**
 * Runs a browser test using Fluentium against a play application on a server port.
 */
class BrowserSpec extends PlaySpec
  with OneBrowserPerTest
  with GuiceOneServerPerTest
  with HtmlUnitFactory
  with ServerProvider {

  "Multi-valie query string parameters" should {

    "be passed to controller in correct order" in {

      goTo ("http://localhost:" + port + "/?p2=1&p1=1&p1=2&p1=3")

      pageSource must === ("p2=1&p1=1&p1=2&p1=3")
    }
  }
}
