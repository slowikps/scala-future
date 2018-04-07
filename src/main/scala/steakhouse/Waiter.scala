package steakhouse

import scala.concurrent.{Await, Future}

sealed trait Meal

object StandardMeal extends Meal
object HouseSpecial extends Meal

class Waiter {

  private val chef: Chef           = new Chef
  private val bartender: Bartender = new Bartender

  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.concurrent.duration._

  def order(meal: Meal): List[String] = meal match {
    case StandardMeal => {
      val futureSteak: Future[String] = chef.hugeSteak()
      val mashedPotato: String = chef.mashedPotato()
      val beer: String = bartender.beer()

      val steak: String = ??? //How to change futureSteak into steak?

      List(steak, mashedPotato, beer)
    }
  }

}
