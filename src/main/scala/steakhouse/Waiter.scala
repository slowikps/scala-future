package steakhouse

import scala.concurrent.Await

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
      val futureSteak = chef.hugeSteak()
      val mashedPotato = chef.mashedPotato()
      val beer = bartender.beer()

      val steak = Await.result(futureSteak, 10 seconds)

      List(steak, mashedPotato, beer)
    }
  }

}
