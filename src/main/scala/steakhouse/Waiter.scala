package steakhouse

import scala.concurrent.Future

sealed trait Meal

object StandardMeal extends Meal
object HouseSpecial extends Meal

class Waiter {

  private val chef: Chef           = new Chef
  private val bartender: Bartender = new Bartender

  import scala.concurrent.ExecutionContext.Implicits.global

  def order(meal: Meal): Future[List[String]] = meal match {
    case StandardMeal => {
      val steakF  = chef.hugeSteak()
      val potatoF = chef.mashedPotato()
      val beerF   = bartender.beer()

      Future.sequence(
        List(steakF, Future.successful(potatoF), beerF)
      )
    }
  }

}
