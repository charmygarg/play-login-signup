package controllers

import models.{PersonLogin, Person, User}
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.Controller

class Mapping extends Controller {

  val personSignUpForm = Form(mapping(
    "fName" -> nonEmptyText,
    "mName" -> text,
    "lName" -> nonEmptyText,
    "username" -> nonEmptyText,
    "password" -> nonEmptyText,
    "user" -> mapping(
      "phone" -> nonEmptyText,
      "gender" -> nonEmptyText,
      "age" -> number(min = 18, max = 75),
      "hobby" -> list(text),
      "isEnable" -> boolean
    )(User.apply)(User.unapply)
  )(Person.apply)(Person.unapply))

  val personLoginForm = Form(mapping(
    "username" -> nonEmptyText,
    "password" -> nonEmptyText)
  (PersonLogin.apply)(PersonLogin.unapply))

}
