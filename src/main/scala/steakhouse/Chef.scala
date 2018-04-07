package steakhouse
import Utils._

import scala.concurrent.{ExecutionContext, Future}

class Chef {

  def pepperSauce()(implicit ec: ExecutionContext): Future[String] = delay("pepper sauce", 300)

  def mashedPotato(): String = "mashed potato"

  def hugeSteak()(implicit ec: ExecutionContext): Future[String] = delay("huge steak", 400)

}
