package domain

import play.api.libs.json.Json

case class Company(bs: String,
                   catchPhrase: String,
                   name: String
                  )

object Company {
  implicit val jsonReads = Json.reads[Company]
  implicit val jsonWrites = Json.writes[Company]
}