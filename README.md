# 💸 Pricing Optimizer (Scala)

## 📌 Project Name
**Pricing Optimizer (Demo) – Scala Edition**

## 💡 Purpose

A simple, modular pricing optimization tool that:

- Generates synthetic price–demand data
- Fits a linear demand model using linear regression
- Predicts optimal price to maximize profit
- Displays a profit vs. price chart
- Includes unit tests for reliability

---

## 🛠️ Getting Started

### ✅ Prerequisites

- IntelliJ IDEA (Community or Ultimate)
- Scala SDK 2.13.x
- sbt 1.5 or later
- Java 11+ (e.g. Amazon Corretto 11)

---

### 📦 Setup

1. Create a Scala sbt project in IntelliJ

2. Add the following `build.sbt`:

```scala
ThisBuild / scalaVersion := "2.13.11"

lazy val root = (project in file("."))
  .settings(
    name := "pricing-optimizer-scala",
    version := "0.1.0",
    libraryDependencies ++= Seq(
      "org.scalanlp" %% "breeze" % "2.1.0",
      "org.knowm.xchart" % "xchart" % "3.8.1",
      "org.scalatest" %% "scalatest" % "3.2.17" % Test
    )
  )
```
---

### 📁 Project Structure
```
src/
├── main/
│   └── scala/
│       └── optimizer/
│           ├── PricingModel.scala
│           ├── PricingPlot.scala
│           └── PricingOptimizerMain.scala
└── test/
    └── scala/
        └── optimizer/
            └── PricingModelSpec.scala
```

---

### ⚙️ Usage Guide

### ▶️ Run the App
Run ```PricingOptimizerMain.scala```. It will:

- Generate synthetic price-demand data

- Fit a linear regression model

- Calculate the profit curve

- Print results

- Show a popup profit chart

### 🖥️ Sample Output
```
📈 Linear Regression Model Coefficients:
Intercept (base demand): 96.15
Slope (price sensitivity): -1.13

💰 Optimal Price: $59.00
📈 Max Profit:   $892.75
```
---

### 📊 Profit Chart
The app pops up a real-time chart showing Profit vs. Price using XChart.

If you don’t see the chart, check behind IntelliJ or ensure ```PricingPlot.show(...)``` is being called.

---

### 🧪 Unit Testing
Test suite is in PricingModelSpec.scala.

Example Tests:
```
Demand prediction at price = 0

Correct profit calculation

Optimal price search logic
```
How to Run:
Right-click PricingModelSpec → Run

Or use sbt test in terminal
