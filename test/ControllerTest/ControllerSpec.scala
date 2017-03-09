package ControllerTest

import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by Charmy Garg on 09-Mar-17.
  */
class ControllerSpec extends PlaySpec with OneAppPerTest {

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
