package TemplateTest

import org.scalatestplus.play.PlaySpec

/**
  * Created by Charmy Garg on 09-Mar-17.
  */
class TemplateSpec extends PlaySpec {

  "LoginController" should {
    "render index template" in new App {
      val html = views.html.login()
      contentAsString(html) must contain("Play Login Page")
    }
  }
}
