package controllers

import play.api.mvc.{Controller, Action}

class WelcomeController extends Controller {

  def welcome = Action {
    Ok(views.html.header())
  }

}
