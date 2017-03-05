package controllers

import javax.inject._
import play.api._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

//  def login = Action {
//    { implicit request =>
//
//      val email = request.body.asFormUrlEncoded.get("email")(0)
//      val password = request.body.asFormUrlEncoded.get("password")(0)
//
//      loginForm.bindFromRequest.fold(
//        errors => BadRequest(html.index(emailForm,errors,"Please enter valid username password")),
//        contact => Redirect(routes.Application.home).withSession("email" -> email,"password" -> password)
//      )
//    }
//  }


}
