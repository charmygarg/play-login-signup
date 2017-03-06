package controllers

import javax.inject.Inject
import models.{User, Person}
import play.api.cache._
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.{Action, Controller}

/**
  * Created by Charmy Garg on 04-Mar-17.
  */
class SignUpController @Inject() (cache: CacheApi) extends Controller{

  val person = Form(mapping(
    "fName" -> nonEmptyText,
    "mName" -> text,
    "lName" -> nonEmptyText,
    "username" -> nonEmptyText,
    "password" -> nonEmptyText,
    "user" -> mapping(
      "phone" -> nonEmptyText,
      "gender" -> nonEmptyText,
      "age" -> number(min = 18, max = 75),
      "hobby" -> list(text)
    )(User.apply)(User.unapply)
  )(Person.apply)(Person.unapply))

  def signup = Action {
    Ok(views.html.signup())
  }

  def create() = Action { implicit request =>
      person.bindFromRequest.fold(
        formWithErrors => Ok("value" + formWithErrors),
        value => {
          val user = cache.get[models.Person](value.username)
          user match {
            case Some(data) => Redirect(routes.LoginController.login).flashing("success" -> "Please login")
            case None => cache.set(value.username, value)
              Redirect(routes.ProfileController.profile).withSession(request.session + ("userSession" -> s"${value.username}"))
          }
        })
    }

}
