package steakhouse

import org.scalatest.{FlatSpec, Matchers}

class WaiterSpec extends FlatSpec with Matchers {

  val sut = new Waiter

  "A waiter" should "be able to deliver a standard meal" in {
    sut.order(StandardMeal) should ===(List("huge steak", "mashed potato", "beer"))
  }
}
