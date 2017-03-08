package controllers

import com.google.inject.Inject
import play.api.mvc.{Action, Controller}
import services.ManagementService


/**
  * Created by Charmy Garg on 08-Mar-17.
  */
class ManagementController @Inject()(managementService: ManagementService) extends Controller{

  def management = Action { implicit request=>

    val list = managementService.getList
    Ok(views.html.management(list))
  }

  def enableUser(username:String) = Action{ implicit request=>
    managementService.enableUser(username)
    Redirect(routes.LoginController.management()).flashing(
      "success" -> "User enabled successfully")
  }

  def disableUser(username:String) = Action{ implicit request=>
    managementService.disableUser(username)
    Redirect(routes.LoginController.management()).flashing(
      "success" -> "User disabled successfully")
  }

}
