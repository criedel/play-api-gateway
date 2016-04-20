package api

import domain.{Post, User}
import play.api.libs.json.Json

case class ApiUser(user: Option[User],
                   posts: Option[Seq[Post]])

object ApiUser {
  implicit val jsonReads = Json.reads[ApiUser]
  implicit val jsonWrites = Json.writes[ApiUser]
}