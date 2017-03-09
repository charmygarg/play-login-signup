package controllers

import models.{PersonLogin, Person}
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.Controller

class Mapping extends Controller{

  val personSignUpForm = Form(mapping(
    "name" -> nonEmptyText,
    "username" -> nonEmptyText,
    "password" -> nonEmptyText
  )(Person.apply)(Person.unapply))

  val personLoginForm = Form(mapping(
    "username" -> nonEmptyText,
    "password" -> nonEmptyText)
  (PersonLogin.apply)(PersonLogin.unapply))

}
