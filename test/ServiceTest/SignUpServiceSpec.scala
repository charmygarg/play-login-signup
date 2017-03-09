package ServiceTest

import models.{Person, User}
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._
import org.scalatestplus.play.PlaySpec
import play.api.cache.CacheApi
import services.SignUpServiceTrait

/**
  * Created by Charmy Garg on 09-Mar-17.
  */
class SignUpServiceSpec extends PlaySpec with MockitoSugar {

  "SignUp Service" should {
    "get set into cache #setCache" in {
      val cache = mock[CacheApi]
      cache.set("key", Person("", "", "", "charmygarg", "", User("", "", 0, List(""), false)))
      val signUpService = mock[SignUpServiceTrait]
      when(signUpService.setCache(Person("", "", "", "charmygarg", "", User("", "", 0, List(""), false)))) thenReturn true
    }
  }

}
