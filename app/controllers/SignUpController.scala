package controllers

import javax.inject.Inject
import play.api.mvc.{Action, Controller}
import services.{SignUpService, MD5}

class SignUpController @Inject() (signUpService: SignUpService) extends Controller{

  val map = new Mapping

  def personSignUpForm = Action { implicit request =>
    Ok(views.html.personSignUpForm())
  }

  def create = Action { implicit request =>
      map.personSignUpForm.bindFromRequest.fold(
        formWithErrors => Ok("value" + formWithErrors),
        value => {
          signUpService.setCache(value)
          Ok(views.html.profile(value.name,value.username,value.password)).withSession(request.session + ("userSession" -> s"${value.username}"))
        })
    }

}
