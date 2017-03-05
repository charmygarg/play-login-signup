package controllers

import javax.inject._
import model.{User, Person}
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.{Action, Controller}

/**
  * Created by Charmy Garg on 04-Mar-17.
  */
class SignUpController @Inject extends Controller{

  val person = Form(mapping(
    "fName" -> nonEmptyText,
    "mName" -> nonEmptyText,
    "lName" -> nonEmptyText,
    "username" -> nonEmptyText,
    "password" -> nonEmptyText,
    "cPassword" -> nonEmptyText,
    "user" -> mapping(
      "phone" -> number(min = 0, max = 9),
      "gender" -> nonEmptyText,
      "age" -> number(min = 18, max = 75),
      "hobby" -> nonEmptyText
    )(User.apply)(User.unapply)
  )(Person.apply)(Person.unapply)
  )

  def signup = Action {
    Ok(views.html.signup())
  }

  def create = Action{ implicit request =>
    person.bindFromRequest.fold(
      formWithErrors => BadRequest("Oh no, invalid submission!"),
      value => Ok("created: " + value)
    )
  }
}
