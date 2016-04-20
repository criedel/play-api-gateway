package controllers

import javax.inject._

import api.ApiUser
import domain.{Post, User}
import play.api.libs.json.Json
import play.api.mvc._
import services.ApiClient

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class UserController @Inject()(apiClient: ApiClient)(implicit exec: ExecutionContext) extends Controller {

  def mergeUserAndPosts(userId: String) = Action.async {

    import ApiUser._

    val futureUsers: Future[Option[User]] = apiClient.getUser(userId)
    val futurePosts: Future[Option[Seq[Post]]] = apiClient.getPosts(userId)

    val response = for {
      user <- futureUsers
      posts <- futurePosts
    } yield Json.toJson(ApiUser(user, posts))

    response.map(apiUser => Ok(apiUser))
  }

  def defaultRedirect() = Action {
    Redirect("/users/1")
  }
}
