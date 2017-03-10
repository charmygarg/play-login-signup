package controllers

import play.api.mvc.{Controller, Action}
import play.api.routing.JavaScriptReverseRouter

/**
  * Created by Charmy Garg on 10-Mar-17.
  */
class JavascriptRouteController extends Controller {

  def jsRoutes = Action { implicit request =>
    Ok(
      JavaScriptReverseRouter("jsRoutes")(
        routes.javascript.SignUpController.personSignUpForm,
        routes.javascript.SignUpController.signUpAction
      )
    ).as("text/javascript")
  }

}
