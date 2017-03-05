package controllers

import play.api.mvc.{Controller, Action}

/**
  * Created by Charmy Garg on 04-Mar-17.
  */
class WelcomeController extends Controller{

  def welcome = Action {
    Ok(views.html.header())
  }

}
