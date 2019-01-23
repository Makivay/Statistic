package ru.makivay

import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import org.apache.commons.math3.distribution.NormalDistribution
import ru.makivay.chart.MeanChart
import ru.makivay.chart.SampleValuesChart
import ru.makivay.utils.SampleUtils.Companion.getSample

class App : Application() {
    private val distribution = NormalDistribution(10.0, 10.0)
    override fun start(stage: Stage) {
        stage.title = "Lab 1"

//        val sampleSize = 2000
//        val sample = getSample(sampleSize)
//        val chart = SampleValuesChart(sample)

        val chart = MeanChart()

        val scene = Scene(chart, 800.0, 600.0)

        stage.scene = scene
        stage.show()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(App::class.java, *args)
        }
    }
}

