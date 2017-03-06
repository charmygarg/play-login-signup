package controllers

import javax.inject.Inject
import models.{User, Person, PersonLogin}
import play.api.cache.CacheApi
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.{Action, Controller}

/**
  * Created by Charmy Garg on 04-Mar-17.
  */
class LoginController @Inject() (cache: CacheApi) extends Controller{

 def login = Action {
    Ok(views.html.login())
  }

  val personLogin = Form(mapping(
    "username" -> nonEmptyText,
    "password" -> nonEmptyText)
  (PersonLogin.apply)(PersonLogin.unapply))

  def create() = Action { implicit request =>
    personLogin.bindFromRequest.fold(
      formWithErrors => Ok("value" + formWithErrors),
      value => {
        val user = cache.get[models.Person](value.username)
        user match {
          case Some(Person(fName, mName, lName, username, password, User(phone, gender, age, hobby))) =>
            if(password == value.password)
              Redirect(routes.ProfileController.profile).withSession(request.session + ("userSession" -> s"${value.username}"))
            else
              Redirect(routes.LoginController.login).flashing("failure" -> "Username or Password is incorrect")
          case None=>  Redirect(routes.LoginController.login).flashing("failure" -> "Not a valid User")
        }
      })
  }

}
