import play.api.http.HttpErrorHandler
import play.api.mvc._
import play.api.mvc.Results._
import scala.concurrent._

class ErrorHandler extends HttpErrorHandler {

  def onClientError(request: RequestHeader, statusCode: Int, message: String) = {

    statusCode match {
      case 400 => Future.successful(Status(statusCode)("Bad Request"))
      case 401 => Future.successful(Status(statusCode)("Authorization Required"))
      case 403 => Future.successful(Status(statusCode)("Forbidden area"))
      case 404 => Future.successful(Status(statusCode)("Page not found"))
      case 407 => Future.successful(Status(statusCode)("Proxy Authentication Required"))
      case 408 => Future.successful(Status(statusCode)("Request Time-Out"))
      case 410 => Future.successful(Status(statusCode)("Gone"))
      case 500 => Future.successful(Status(statusCode)("Internal Server Error"))
      case 502 => Future.successful(Status(statusCode)("Bad Gateway"))
      case 503 => Future.successful(Status(statusCode)("Service Temporarily Unavailable"))
      case 504 => Future.successful(Status(statusCode)("Gateway Time-Out"))
      case _ => Future.successful(Status(statusCode)("Something went wrong!!"))
    }
  }

  def onServerError(request: RequestHeader, exception: Throwable) = {
    Future.successful(
      InternalServerError("A server error occurred: " + exception.getMessage)
    )
  }
}