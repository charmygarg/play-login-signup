package ControllerTest

import controllers.LoginController
import models.Person
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.cache.CacheApi
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by Charmy Garg on 10-Mar-17.
  */
class LoginControllerSpec extends PlaySpec with OneAppPerTest with MockitoSugar {

  "LoginController" should {
    "render the login page" in {
      val login = route(app, FakeRequest(GET, "/login")).get
      status(login) mustBe OK
      contentType(login) mustBe Some("text/html")
    }

//    "render profile page" in {
//      val cache = mock[CacheApi]
//      val loginController = new LoginController(cache)
//      when(cache.get[Person]("")) thenReturn None
//      val result = loginController.create.apply(FakeRequest(GET, "/login").withFormUrlEncodedBody(("username","Charmy"),("password","1234")))
//      status(result) mustBe OK
//      contentType(result) mustBe Some("text/html")
//    }
  }

}
