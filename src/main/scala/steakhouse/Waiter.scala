package steakhouse

sealed trait Meal

object StandardMeal extends Meal
object HouseSpecial extends Meal

class Waiter {

  private val chef: Chef           = new Chef
  private val bartender: Bartender = new Bartender

  def order(meal: Meal) = meal match {
    case StandardMeal =>
      List(
        chef.hugeSteak(),
        chef.mashedPotato(),
        bartender.beer()
      )
  }

}
