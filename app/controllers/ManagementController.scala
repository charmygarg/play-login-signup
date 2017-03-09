package controllers

import com.google.inject.Inject
import play.api.mvc.{Action, Controller}
import services.ManagementService

/**
  * Created by Charmy Garg on 08-Mar-17.
  */
class ManagementController @Inject()(managementService: ManagementService) extends Controller {

  def management = Action { implicit request =>
    val user = managementService.getUser
    Ok(views.html.management(user))
  }

  def enableUser(username: String) = Action { implicit request =>
    managementService.enableUser(username)
    Redirect(routes.ManagementController.management()).flashing(
      "success" -> "User has been enabled")
  }

  def disableUser(username: String) = Action { implicit request =>
    managementService.disableUser(username)
    Redirect(routes.ManagementController.management()).flashing(
      "success" -> "User has been disabled")
  }

  def logout = Action {
    Redirect(routes.WelcomeController.welcome()).withNewSession
  }
}
