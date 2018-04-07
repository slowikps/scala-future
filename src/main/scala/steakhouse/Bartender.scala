package steakhouse

import java.util.concurrent.Executors

import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext, Future}

class Bartender {
  import Utils._

  implicit val ec = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(1))
  def beer(): Future[String] = Future{
    Await.result(delay("beer"), Duration.Inf)
  }
}
