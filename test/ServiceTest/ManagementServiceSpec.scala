package ServiceTest

import models.{User, Person}
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._
import org.scalatestplus.play.PlaySpec
import play.api.cache.CacheApi
import services.ManagementServiceTrait


/**
  * Created by Charmy Garg on 09-Mar-17.
  */
class ManagementServiceSpec extends PlaySpec with MockitoSugar {

  "Management Service" should {
    "get user from #getUser" in {
      val cache = mock[CacheApi]
      cache.set("key", Person("", "", "", "charmygarg", "", User("", "", 0, List(""), false)))
      val managementService = mock[ManagementServiceTrait]
      when(managementService.getUser) thenReturn " "
    }

    "enable user #enableUser" in {
      val cache = mock[CacheApi]
      cache.set("key", Person("", "", "", "charmygarg", "", User("", "", 0, List(""), false)))
      val managementService = mock[ManagementServiceTrait]
      when(managementService.enableUser("charmygarg")) thenReturn true

    }

    "disable user #disableUser" in {
      val cache = mock[CacheApi]
      cache.set("key", Person("", "", "", "charmygarg", "", User("", "", 0, List(""), false)))
      val managementService = mock[ManagementServiceTrait]
      when(managementService.enableUser("charmygarg")) thenReturn false

    }
  }

}
