package $organization$.$name;format="lower,word"$

import com.example.HelloWorldServer
import com.twitter.finatra.http.test.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest
import com.twitter.finagle.http.Status._

class HelloWorldFeatureTest extends FeatureTest {

  override val server = new EmbeddedHttpServer(new HelloWorldServer)

  "Server" should {
    "have root path" in {
      server.httpGet(path = "/", andExpect = Ok)
    }

    "say hi" in {
      server.httpGet(
        path = "/hello?name=Bob",
        andExpect = Ok,
        withJsonBody = """{"msg": "Hi there Bob!"}""")
    }
  }
}

