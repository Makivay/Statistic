package ru.makivay.chart

import javafx.scene.chart.BarChart
import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.XYChart
import ru.makivay.utils.SampleUtils

class SampleValuesChart(sample: List<Double>) : BarChart<String, Number>(CategoryAxis(), NumberAxis()) {
    init {
        val series = XYChart.Series<String, Number>()
        series.name = "Normal distribution"

        val sampleMap = SampleUtils.mapSample(sample)

        series.data.addAll(sampleMap.map { (k, v) -> XYChart.Data<String, Number>(k, v) })
        this.data.add(series)
    }
}