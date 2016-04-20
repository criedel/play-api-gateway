package domain

import play.api.libs.json.Json

case class User(address: Address,
                company: Company,
                email: String,
                id: Int,
                name: String,
                phone: String,
                username: String,
                website: String)

object User {
  implicit val jsonReads = Json.reads[User]
  implicit val jsonWrites = Json.writes[User]
}