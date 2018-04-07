package steakhouse
import Utils._

import scala.concurrent.{ExecutionContext, Future}

class Chef {

  def pepperSauce(): String = delay("pepper sauce", 300)

  def mashedPotato(): String = delay("mashed potato")

  def hugeSteak()(implicit ex: ExecutionContext): Future[String] =
    Future(
      delay("huge steak", 400)
    )

}
