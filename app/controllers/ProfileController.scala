package controllers

import models.Person
import javax.inject._
import play.api.cache.CacheApi
import play.api.mvc.{Action, Controller}

class ProfileController @Inject() (cache: CacheApi) extends Controller {

  def profile = Action { implicit request =>
    val usrname = request.session.get("userSession").fold("fake")(x => x)
    val user = cache.get[Person](usrname)
    user match {
      case Some(Person(name, username, password, confirmPassword)) =>
        Ok(views.html.profile(name, username, password))
      case None => Ok(views.html.login()).flashing("success" -> "Please login")
    }
  }

}
