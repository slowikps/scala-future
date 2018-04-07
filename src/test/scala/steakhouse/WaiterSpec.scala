package steakhouse

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Millis, Seconds, Span}
import org.scalatest.{AsyncFlatSpec, Matchers}

class WaiterSpec extends AsyncFlatSpec with Matchers with ScalaFutures {

  val sut = new Waiter

  "A waiter" should "be able to deliver a standard meal" in {
    sut
      .order(StandardMeal)
      .map(
        _ should ===(List("huge steak", "mashed potato", "beer"))
      )
  }

  "A waiter" should "be able to deliver a standard meal below 0.7 second" in {
    implicit val patienceConfig = PatienceConfig(timeout = Span(700, Millis), interval = Span(20, Millis))

    whenReady(sut.order(StandardMeal)) {
      _ should ===(List("huge steak", "mashed potato", "beer"))
    }
  }
}
