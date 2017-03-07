package controllers

import javax.inject.Inject
import models.{User, Person}
import play.api.cache.CacheApi
import play.api.mvc.{Action, Controller}

/**
  * Created by Charmy Garg on 04-Mar-17.
  */
class LoginController @Inject() (cache: CacheApi) extends Controller{

  val map = new Mapping

  def login = Action { implicit request =>
    Ok(views.html.login())
  }

  def create() = Action { implicit request =>

    map.personLogin.bindFromRequest.fold(
      formWithErrors => Ok("value" + formWithErrors),
      value => {
        val user = cache.get[models.Person](value.username)
        println(user.toString)
        user match {
          case Some(Person(fName, mName, lName, username, password, User(phone, gender, age, hobby))) =>
            if(password == value.password)
              Redirect(routes.ProfileController.profile()).withSession(request.session + ("userSession" -> s"${value.username}"))
            else
              Redirect(routes.LoginController.login()).flashing("success" -> "Username or Password is incorrect")
          case None=>  Redirect(routes.LoginController.login()).flashing("success" -> "Not a valid User")
        }
      })
  }

}
