package ru.makivay.utils

import org.apache.commons.math3.distribution.NormalDistribution
import kotlin.math.round
import kotlin.math.sqrt

class SampleUtils {
    companion object {
        private const val mean = 10.0
        private const val sd = 10.0
        private val distribution = NormalDistribution(mean, sd)

        @JvmStatic
        fun getSample(size: Int): List<Double> = distribution.sample(size).toList()

        @JvmStatic
        fun mapSample(sample: List<Double>): Map<String, Int> {
            val min = sample.min()!!.toInt()
            val max = sample.max()!!.toInt()
            val count = sample.sorted().groupingBy { value -> round(value).toInt().toString() }.eachCount()
            val map = LinkedHashMap<String, Int>(max - min)
            for (i in min..max) {
                val key = i.toString()
                map[key] = count.getOrDefault(key, 0)
            }
            return map
        }

        @JvmStatic
        fun mean(sample: List<Double>) = sample.sum() / sample.size

        @JvmStatic
        fun upperBorder(size: Int): Double = mean + (3 * (1 / sqrt(size.toDouble())) * sd)

        @JvmStatic
        fun lowerBorder(size: Int): Double = mean - (3 * (1 / sqrt(size.toDouble())) * sd)
    }
}