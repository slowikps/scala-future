package steakhouse
import steakhouse.Utils._

object Client extends App {
  val waiter = new Waiter()

  info(
    waiter.order(StandardMeal).toString()
  )
}
