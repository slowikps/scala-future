package steakhouse

import scala.concurrent.{ExecutionContext, Future}

class Bartender {
  import Utils._

  def beer()(implicit ec: ExecutionContext): Future[String] = delay("beer")
}
