package steakhouse

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Millis, Span}
import org.scalatest.{AsyncFlatSpec, Matchers}

class WaiterSpec extends AsyncFlatSpec with Matchers with ScalaFutures {

  val sut = new Waiter

  override implicit val patienceConfig = PatienceConfig(timeout = Span(500, Millis), interval = Span(20, Millis))

  "A waiter" should "be able to deliver a standard meal" in {
    whenReady(sut.order(StandardMeal)) {
      _ should ===(List("huge steak", "mashed potato", "beer"))
    }
  }

  "A waiter" should "be able to deliver a standard meal below 0.7 second" in {
    Utils.restartTimer()

    whenReady(sut.order(StandardMeal)) {
      _ should ===(List("huge steak", "mashed potato", "beer"))
    }
  }
}
