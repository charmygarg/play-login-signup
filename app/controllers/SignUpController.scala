package controllers

import javax.inject.Inject
import play.api.mvc.{Action, Controller}
import services.{SignUpService, MD5}

class SignUpController @Inject() (signUpService: SignUpService) extends Controller{

  val map = new Mapping

  def signup = Action { implicit request =>
    Ok(views.html.signup())
  }

  def create() = Action { implicit request =>
      map.person.bindFromRequest.fold(
        formWithErrors => Ok("value" + formWithErrors),
        value => {
            val encrypt = value.copy(password = MD5.hash(value.password))
            signUpService.setCache(encrypt)
            Redirect(routes.ProfileController.profile()).withSession(request.session + ("userSession" -> s"${value.username}"))
        })
    }

}
