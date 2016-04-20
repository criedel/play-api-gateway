package domain

import play.api.libs.json.Json

case class GeoLocation(lat: String, lng: String)

object GeoLocation {
  implicit val jsonReads = Json.reads[GeoLocation]
  implicit val jsonWrites = Json.writes[GeoLocation]
}