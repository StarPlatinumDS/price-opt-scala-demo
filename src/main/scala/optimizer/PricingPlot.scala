package optimizer

import org.knowm.xchart.{XYChartBuilder, SwingWrapper}
import org.knowm.xchart.style.markers.None

object PricingPlot {

  def show(model: PricingModel, cost: Double): Unit = {
    val curve = model.profitCurve(cost)
    val prices = curve.map(_._1).toArray
    val profits = curve.map(_._2).toArray

    val chart = new XYChartBuilder()
      .width(600).height(400)
      .title("Profit vs. Price")
      .xAxisTitle("Price")
      .yAxisTitle("Profit")
      .build()

    val series = chart.addSeries("Profit", prices, profits)
    series.setMarker(new None())

    new SwingWrapper(chart).displayChart()
  }
}