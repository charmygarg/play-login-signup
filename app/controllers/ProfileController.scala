package controllers

import models.{User, Person}
import javax.inject._
import play.api.cache.CacheApi
import play.api.mvc.{Action, Controller}

class ProfileController @Inject() (cache: CacheApi) extends Controller {

  def profile = Action { implicit request =>
    val usrname = request.session.get("userSession").fold("fake")(x => x)
    val user = cache.get[Person](usrname)
    user match {
      case Some(Person(fName, mName, lName, username, password, User(phone, gender, age, hobby, status, isEnable))) =>
        Ok(views.html.profile(fName, mName, lName, username, password, phone, gender, age, hobby))
      case None => Redirect(routes.LoginController.login).flashing("success" -> "Please login")
    }
  }

}
