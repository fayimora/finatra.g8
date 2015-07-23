package $organization$.$name;format="lower,word"$

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.twitter.finatra.request._
import com.twitter.finatra.validation._

case class HelloRequest(@RequestInject req: Request, @NotEmpty @QueryParam name: Option[String])

class HelloWorldController extends Controller {

  get("/") { request: Request =>
    response.ok.json("Welcome, please visit /hello")
  }

  get("/hello") { req: HelloRequest =>
    info(s"I got here via a ${req.req.method} request!")
    val name = req.name.getOrElse("Human")
    response.ok.json(Map("msg" -> s"Hi there ${name}!"))
  }
}

