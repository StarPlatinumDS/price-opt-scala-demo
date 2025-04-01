package optimizer

import breeze.linalg._
import breeze.stats.distributions._
import breeze.stats.distributions.ThreadLocalRandomGenerator
import org.apache.commons.math3.random.MersenneTwister

case class PricingModel(
                       intercept: Double,
                       slope: Double
                       ) {
  def predictDemand(price: Double): Double =
    intercept + slope * price

  def computeProfit(price: Double, cost: Double): Double = {
    val demand = predictDemand(price)
    (price - cost) * demand
  }

  def optimalPrice(cost: Double, priceRange: Range = 20 to 80): (Double, Double) = {
    priceRange
      .map(p => (p.toDouble, computeProfit(p, cost)))
      .maxBy(_._2)
  }

  def profitCurve(cost: Double, priceRange: Range = 20 to 80): Seq[(Double, Double)] = {
    priceRange.map(p => (p.toDouble, computeProfit(p, cost)))
  }
}

object PricingModel {

  def fit(x: DenseMatrix[Double], y: DenseVector[Double]): PricingModel = {
    val ones = DenseMatrix.ones[Double](x.rows, 1)
    val xWithBias = DenseMatrix.horzcat(ones, x)

    val beta = inv(xWithBias.t * xWithBias) * xWithBias.t * y
    PricingModel(beta(0), beta(1))
  }

  def generateSyntheticData(n: Int): (DenseMatrix[Double], DenseVector[Double]) = {
    val rand = new RandBasis(new ThreadLocalRandomGenerator(new MersenneTwister(42)))

    val x = DenseMatrix.rand(n, 1, Uniform(20.0, 80.0)(rand))

    val a = 100.0
    val b = 1.2
    val noise = Gaussian(0.0, 10.0)(rand).sample(n).toArray

    val y = DenseVector((0 until n).map { i =>
      a - b * x(i, 0) + noise(i)
    }.toArray)

    (x, y)
  }
}