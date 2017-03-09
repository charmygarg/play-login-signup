package RouterTest

import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by Charmy Garg on 09-Mar-17.
  */
class RouterSpec extends PlaySpec with OneAppPerTest {

  "Routes" should {

    "send 404 on a bad request" in {
      route(app, FakeRequest(GET, "/boum")).map(status(_)) mustBe Some(NOT_FOUND)
    }

    "respond to the login Action" in {
      val Some(result) = route(app, FakeRequest(GET, "/login"))
      status(result) mustBe OK
      contentType(result) mustBe Some("text/html")
      charset(result) mustBe Some("utf-8")
      contentAsString(result) must include("Play Login Page")
    }

    "respond to the profile Action" in {
      val Some(result) = route(app, FakeRequest(GET, "/profile"))
      status(result) mustBe SEE_OTHER
      contentType(result) mustBe None
      charset(result) mustBe None
      contentAsString(result) must include("")
    }

    "respond to the welcome Action" in {
      val Some(result) = route(app, FakeRequest(GET, "/welcome"))
      status(result) mustBe OK
      contentType(result) mustBe Some("text/html")
      charset(result) mustBe Some("utf-8")
      contentAsString(result) must include("Play Welcome Page")
    }

    "respond to the signUp Action" in new App() {
      val Some(result) = route(app, FakeRequest(GET, "/signUp"))
      status(result) mustBe OK
      contentType(result) mustBe Some("text/html")
      charset(result) mustBe Some("utf-8")
      contentAsString(result) must include("Play SignUp Page")
    }

    "respond to the create of LoginController Action" in {
      val Some(result) = route(app, FakeRequest(GET, "/create"))
      status(result) mustBe BAD_REQUEST
      contentType(result) mustBe Some("text/plain")
      charset(result) mustBe Some("utf-8")
      contentAsString(result) must include("form with errors")
    }

    "respond to the create of ManagementController Action" in new App() {
      val Some(result) = route(app, FakeRequest(GET, "/management"))
      status(result) mustBe Some(OK)
      contentType(result) mustBe Some("text/html")
      charset(result) mustBe Some("utf-8")
      contentAsString(result) must include("Play Management Page")
    }

    "respond to the enable of ManagementController Action" in new App() {
      val Some(result) = route(app, FakeRequest(GET, "/enable/:username"))
      status(result) mustBe Some(OK)
      contentType(result) mustBe Some("text/html")
      charset(result) mustBe Some("utf-8")
      contentAsString(result) must include("Play Management Page")
    }

    "respond to the disable of ManagementController Action" in new App() {
      val Some(result) = route(app, FakeRequest(GET, "/disable/:username"))
      status(result) mustBe Some(OK)
      contentType(result) mustBe Some("text/html")
      charset(result) mustBe Some("utf-8")
      contentAsString(result) must include("Play Management Page")
    }
  }

}
