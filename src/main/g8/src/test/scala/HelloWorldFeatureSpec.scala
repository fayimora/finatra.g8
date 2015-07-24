package $organization$.$name;format="lower,word"$

import $organization$.$name;format="lower,word"$.HelloWorldServer
import com.twitter.finatra.http.test.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest
import com.twitter.finagle.http.Status._

class HelloWorldFeatureTest extends FeatureTest {

  override val server = new EmbeddedHttpServer(new HelloWorldServer)

  "Server" should {
    "have root path" in {
      server.httpGet(path = "/", andExpect = Ok)
    }
  }
}

