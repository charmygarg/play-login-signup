package controllers

import models.{PersonLogin, Person, User}
import play.api.data.Form
import play.api.data.Forms._

/**
  * Created by Charmy Garg on 07-Mar-17.
  */
class Mapping {

  val person = Form(mapping(
    "fName" -> nonEmptyText,
    "mName" -> text,
    "lName" -> nonEmptyText,
    "username" -> nonEmptyText,
    "password" -> nonEmptyText,
    "user" -> mapping(
      "phone" -> nonEmptyText,
      "gender" -> nonEmptyText,
      "age" -> number(min = 18, max = 75),
      "hobby" -> list(text)
    )(User.apply)(User.unapply)
  )(Person.apply)(Person.unapply))

  val personLogin = Form(mapping(
    "username" -> nonEmptyText,
    "password" -> nonEmptyText)
  (PersonLogin.apply)(PersonLogin.unapply))

}
