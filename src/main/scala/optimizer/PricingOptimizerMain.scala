package optimizer

object PricingOptimizerMain extends App {

  val (x, y) = PricingModel.generateSyntheticData(100)
  val model = PricingModel.fit(x, y)

  println("\uD83D\uDCC8 Linear Regression Model Coefficients:")
  println(f"Intercept (base demand): ${model.intercept}%.2f")
  println(f"Slope (price sensitivity): ${model.slope}%.2f")

  val cost = 30.0
  val (optimalPrice, maxProfit) = model.optimalPrice(cost)

  println()
  println(f"💰 Optimal Price: $$${optimalPrice}%.2f")
  println(f"📈 Max Profit:   $$${maxProfit}%.2f")

  //Optimal Chart
  PricingPlot.show(model, cost)
}