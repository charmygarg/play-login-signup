package controllers

import play.api.mvc.{Action, Controller}

/**
  * Created by Charmy Garg on 04-Mar-17.
  */
class ProfileController extends Controller {

  def profile = Action {
    Ok(views.html.profile())
  }

}
