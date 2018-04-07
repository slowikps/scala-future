package steakhouse

import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.util.{Failure, Success}

class Bartender {
  import Utils._

  def beer()(implicit ec: ExecutionContext): Future[String] = {
    val p = Promise[String]
    delay("beer").onComplete {
      case Success(success) => p.trySuccess(success)
      case Failure(cause)   => p.tryFailure(cause)
    }
    p.future
  }
}
