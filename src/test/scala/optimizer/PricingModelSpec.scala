package optimizer

import org.scalatest.funsuite.AnyFunSuite

class PricingModelSpec extends AnyFunSuite {

  test("predictDemand should return intercept when price is 0") {
    val model = PricingModel(100.0, -1.5)
    val result = model.predictDemand(0.0)
    assert(result == 100.0)
  }

  test("computeProfit should calculate correct profit") {
    val model = PricingModel(100.0, -1.0)
    val price = 50.0
    val cost = 20.0

    val demand = model.predictDemand(price) //100-50=50
    val expectedProfit = (price - cost) * demand

    assert(model.computeProfit(price, cost) == expectedProfit)
  }

  test("optimalPrice should return max profit within range") {
    val model = PricingModel(100.0, -1.0)
    val (bestPrice, maxProfit) = model.optimalPrice(cost = 30, priceRange = 20 to 80)

    assert(bestPrice > 30.0 && bestPrice <= 80)
    assert(maxProfit > 0.0)
  }
}
