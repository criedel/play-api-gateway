package domain

import play.api.libs.json.Json

case class Post(body: String,
                id: Int,
                title: String,
                userId: Int
               )

object Post {
  implicit val jsonReads = Json.reads[Post]
  implicit val jsonWrites = Json.writes[Post]
}