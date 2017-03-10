package controllers

import javax.inject.Inject
import models.Person
import play.api.mvc.{Action, Controller}
import play.api.routing._
import routes.javascript._
import services.SignUpService

class SignUpController @Inject() (signUpService: SignUpService) extends Controller{

  //val map = new Mapping

  def personSignUpForm = Action { implicit request =>
    Ok(views.html.personSignUpForm())
  }

  def signUpAction(name: String, username: String, password: String, confirmPassword: String) = Action { implicit request =>
    if(password == confirmPassword) {
      val data = Person(name, username, password, confirmPassword)
      signUpService.setCache(data)
      Ok(views.html.profile(name, username, password))
    }
    else {
      Ok("Password doesn't match")
    }
  }

}
