import org.scalatestplus.play._
import play.api.test._
import play.api.test.Helpers._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
class ApplicationSpec extends PlaySpec with OneAppPerTest {

  "Routes" should {

    "send 404 on a bad request" in  {
      route(app, FakeRequest(GET, "/boum")).map(status(_)) mustBe Some(NOT_FOUND)
    }

  }

  "HomeController" should {

    "render the index page" in {
      val home = route(app, FakeRequest(GET, "/")).get

      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include ("Play Welcome Page")
    }

  }

  "CountController" should {

    "return an increasing count" in {
      contentAsString(route(app, FakeRequest(GET, "/count")).get) mustBe "0"
      contentAsString(route(app, FakeRequest(GET, "/count")).get) mustBe "1"
      contentAsString(route(app, FakeRequest(GET, "/count")).get) mustBe "2"
    }

  }

  "LoginController" should {

    "render the login page" in {
      val login = route(app, FakeRequest(GET,"/login")).get

      status(login) mustBe OK
      contentType(login) mustBe Some("text/html")
    }

  }

  "ManagementController" should {

    "render the login page" in {
      val management = route(app, FakeRequest(GET,"/management")).get

      status(management) mustBe OK
      contentType(management) mustBe Some("text/html")
    }

  }

  "SignUpController" should {

    "render the login page" in {
      val signUp = route(app, FakeRequest(GET,"/signUp")).get

      status(signUp) mustBe OK
      contentType(signUp) mustBe Some("text/html")
    }
  }

  "WelcomeController" should {

    "render the login page" in {
      val welcome = route(app, FakeRequest(GET,"/welcome")).get

      status(welcome) mustBe OK
      contentType(welcome) mustBe Some("text/html")
    }
  }

}
