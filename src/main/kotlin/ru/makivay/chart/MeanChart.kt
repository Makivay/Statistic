package ru.makivay.chart

import javafx.scene.chart.LineChart
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.XYChart
import ru.makivay.utils.SampleUtils

class MeanChart :
    LineChart<Number, Number>(NumberAxis().apply { id = "N" }, NumberAxis().apply { id = "mean" }) {
    init {

        val meanSeries = XYChart.Series<Number, Number>().apply { name = "mean" }
        val upperBorderSeries = XYChart.Series<Number, Number>().apply { name = "upperBorder" }
        val lowerBorderSeries = XYChart.Series<Number, Number>().apply { name = "lowerBorder" }
        for (i in 1..2000) {
            val size = i * 1
            val sample = SampleUtils.getSample(size)

            val mean = SampleUtils.mean(sample)
            meanSeries.data.add(XYChart.Data<Number, Number>(size, mean))

            val upperBorder = SampleUtils.upperBorder(size)
            upperBorderSeries.data.add(XYChart.Data<Number, Number>(size, upperBorder))

            val lowerBorder = SampleUtils.lowerBorder(size)
            lowerBorderSeries.data.add(XYChart.Data<Number, Number>(size, lowerBorder))

        }
        this.data.add(upperBorderSeries)
        this.data.add(lowerBorderSeries)
        this.data.add(meanSeries)

    }
}