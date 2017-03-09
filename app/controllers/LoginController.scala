package controllers

import javax.inject.Inject
import models.Person
import play.api.cache.CacheApi
import play.api.routing._
import play.api.mvc.{Action, Controller}
import services.MD5
import views.html.helper.javascriptRouter

class LoginController @Inject() (cache: CacheApi) extends Controller{

  val map = new Mapping

  def login = Action { implicit request =>
    Ok(views.html.index())
  }

  def create() = Action { implicit request =>
    map.personLoginForm.bindFromRequest.fold(
      formWithErrors => BadRequest("value" + formWithErrors),
      value => {
        val user = cache.get[models.Person](value.username)
        user match {
          case Some(Person(name, username, password)) =>
            if(password == MD5.hash(value.password))
                Ok(views.html.profile(name, username, password)).withSession(request.session + ("userSession" -> s"${value.username}"))
            else
              Ok(views.html.index()).flashing("success" -> "Username or Password is incorrect")
          case None =>  Ok(views.html.index()).flashing("success" -> "Not a valid User")
        }
      })
  }

  def javascriptRoutes = Action { implicit request =>
    Ok(
      javascriptRouter("jsRoutes")(
        controllers.routes.javascript.LoginController.create
      )
    ).as(JAVASCRIPT)
  }
}
