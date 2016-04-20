package domain

import play.api.libs.json.Json

case class Address(city: String,
                   geo: GeoLocation,
                   street: String,
                   suite: String,
                   zipcode: String
                  )

object Address {
  implicit val jsonReads = Json.reads[Address]
  implicit val jsonWrites = Json.writes[Address]
}