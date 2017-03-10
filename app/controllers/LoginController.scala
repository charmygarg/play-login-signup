package controllers

import javax.inject.Inject
import models.Person
import play.api.cache.CacheApi
import play.api.routing._
import routes.javascript._
import play.api.mvc.{Action, Controller}
import services.MD5
import views.html.helper.javascriptRouter

class LoginController @Inject() (cache: CacheApi) extends Controller{

  def login = Action { implicit request =>
    Ok(views.html.login())
  }

//  def create = Action { implicit request =>
//
//  }
}
