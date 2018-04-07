package steakhouse

import org.scalatest.{AsyncFlatSpec, Matchers}

class ChefSpec extends AsyncFlatSpec with Matchers {

  val sut = new Chef

  "A chef" should "be able to prepare pepper sauce" in {
    sut
      .pepperSauce()
      .map(
        _ should ===("pepper sauce")
      )
  }

  "A chef" should "be able to prepare mashed potato" in {
    sut.mashedPotato() should ===("mashed potato")
  }

  "A chef" should "be able to prepare huge steak" in {
    sut
      .hugeSteak()
      .map(
        _ should ===("huge steak")
      )
  }
}
