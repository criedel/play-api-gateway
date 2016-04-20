package services

import javax.inject.{Inject, Singleton}

import domain.{Post, User}
import play.api.http.HeaderNames
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.json.JsSuccess
import play.api.libs.ws.WSClient

import scala.concurrent.Future

@Singleton
class ApiClient @Inject() (wsClient: WSClient) {

  val endpoint = "http://jsonplaceholder.typicode.com"

  def getUser(userId: String): Future[Option[User]] = {

    wsClient.url(s"$endpoint/users/$userId").withHeaders(HeaderNames.CONTENT_TYPE -> "application/json").get() map {
      response =>
        response.json.validate[User] match {
          case result: JsSuccess[User] => {
            result.asOpt
          }
          case _ => None
        }
    }
  }

  def getPosts(userId: String): Future[Option[Seq[Post]]] = {

    wsClient.url(s"$endpoint/posts").withQueryString(("userId", userId)).withHeaders(HeaderNames.CONTENT_TYPE -> "application/json").get() map {
      response => response.json.validate[Seq[Post]] match {
        case result: JsSuccess[Seq[Post]] => {
          result.asOpt
        }
        case _ => None
      }
    }
  }
}
