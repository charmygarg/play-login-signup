package controllers

import play.api.mvc.{Action, Controller}

/**
  * Created by Charmy Garg on 04-Mar-17.
  */
class LoginController extends Controller{

  def login = Action {
    Ok(views.html.login())
  }
}
