package controllers

import javax.inject.Inject
import play.api.mvc.{Action, Controller}
import services.{TypeService, SignUpService, MD5}

class SignUpController @Inject()(signUpService: SignUpService, typeService: TypeService) extends Controller {

  val map = new Mapping
  val status = typeService.getType

  def signup = Action { implicit request =>
    Ok(views.html.signup())
  }

  def create = Action { implicit request =>
    map.personSignUpForm.bindFromRequest.fold(
      formWithErrors => BadRequest("form with errors"),
      value => {
        val encrypt = value.copy(password = MD5.hash(value.password))
        signUpService.setCache(encrypt)
        if (status == "Admin") {
          Redirect(routes.ManagementController.management()).withSession(request.session + ("userSession" -> s"${value.username}"))
        } else {
          Redirect(routes.ProfileController.profile()).withSession(request.session + ("userSession" -> s"${value.username}"))
        }
      })
  }

}
