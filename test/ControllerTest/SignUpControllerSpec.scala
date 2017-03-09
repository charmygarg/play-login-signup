package ControllerTest

import controllers.LoginController
import org.scalatest.mock.MockitoSugar
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import org.mockito.Mockito._
import play.api.cache.CacheApi
import play.api.test.FakeRequest
import play.api.test.Helpers._
import services.{TypeService, SignUpService}

/**
  * Created by Charmy Garg on 10-Mar-17.
  */
class SignUpControllerSpec extends PlaySpec with OneAppPerTest with MockitoSugar  {

  "SignUpController" should {
    "render the login page" in {
      val signUp = route(app, FakeRequest(GET, "/signUp")).get
      status(signUp) mustBe OK
      contentType(signUp) mustBe Some("text/html")
    }

//    "render the profile  page" in {
//      val mockSignUpService = mock[SignUpService]
//      val mockTypeService = mock[TypeService]
//      val signUpController = new SignUpControllerSpec(mockSignUpService ,mockTypeService)
//      val result = signUpController.create.apply(FakeRequest(POST, "/create").withFormUrlEncodedBody(
//        ("fName","Charmy"),("mName","Dinesh"),("lName","Garg"),("username","charmygarg"),("password","1234"),("phone","9898765434"),
//        ("gender","female"),("age","22"),("hobbies","programming"),("isEnable","true")))
//      status(result) mustBe OK
//      contentType(result) mustBe Some("text/html")
//    }
  }

}
