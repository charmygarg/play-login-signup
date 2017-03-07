package controllers

import javax.inject.Inject
import play.api.cache._
import play.api.mvc.{Action, Controller}

/**
  * Created by Charmy Garg on 04-Mar-17.
  */
class SignUpController @Inject() (cache: CacheApi) extends Controller{

  val map = new Mapping

  def signup = Action { implicit request =>
    Ok(views.html.signup())
  }

  def create() = Action { implicit request =>
      map.person.bindFromRequest.fold(
        formWithErrors => Ok("value" + formWithErrors),
        value => {
          val user = cache.get[models.Person](value.username)
          user match {
            case Some(data) => Redirect(routes.LoginController.login()).flashing("success" -> "Please login")
            case None => cache.set(value.username, value)
              Redirect(routes.ProfileController.profile()).withSession(request.session + ("userSession" -> s"${value.username}"))
          }
        })
    }

}
