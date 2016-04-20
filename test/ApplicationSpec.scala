import api.ApiUser
import domain.User
import org.scalatestplus.play._
import play.api.libs.json.Json
import play.api.test.Helpers._
import play.api.test._

class ApplicationSpec extends PlaySpec with OneAppPerTest {

  "Json" should {
    "be transformed to POJO" in {
      val userAsJson = """
        |{"id":1,"name":"Leanne Graham","username":"Bret","email":"Sincere@april.biz","address":{"street":"Kulas Light","suite":"Apt. 556","city":"Gwenborough","zipcode":"92998-3874","geo":{"lat":"-37.3159","lng":"81.1496"}},"phone":"1-770-736-8031 x56442","website":"hildegard.org","company":{"name":"Romaguera-Crona","catchPhrase":"Multi-layered client-server neural-net","bs":"harness real-time e-markets"}}
      """.stripMargin

      Json.parse(userAsJson).validate[User].isError mustBe false
    }
  }

  "Routes" should {

    "return the merged user object" in  {
      route(app, FakeRequest(GET, "/users/1")).map(status(_)) mustBe Some(OK)

      import ApiUser._

      val response: Option[ApiUser] = Json.fromJson(contentAsJson(route(app, FakeRequest(GET, "/users/1")).get)).asOpt
      response.isDefined mustBe true
      response.get.user.isDefined mustBe true
      response.get.user.get.id mustBe 1
      response.get.user.get.name mustBe "Leanne Graham"
      response.get.posts.isDefined mustBe true
      response.get.posts.get.size mustBe 10
    }

  }

}
