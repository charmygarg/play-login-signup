package ServiceTest

import org.scalatest.mock.MockitoSugar
import org.scalatestplus.play.PlaySpec
import play.api.cache.CacheApi
import services.ManagementService

/**
  * Created by Charmy Garg on 09-Mar-17.
  */
class ServiceSpec extends PlaySpec with MockitoSugar {

  "Management Service" should {
    "ManagementService#getList" in {
      val service = mock[CacheApi]
      service.getList.mustBe("charmygarg")
    }
  }

}
