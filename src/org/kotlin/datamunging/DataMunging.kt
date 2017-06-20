package org.kotlin.datamunging

import java.io.File
import io.kotlintest.specs.StringSpec
import io.kotlintest.matchers.shouldEqual

class DataMunging : StringSpec() {
	init {
		val lamda: () -> Unit = {
			val lines: List<String> = File("weather.dat").readLines().drop(2).take(30)
			val splitlines: List <WeatherEntry> = lines.map { it.replace("*", "").split(Regex(" +")) }
					.map { WeatherEntry(it[1], it[2].toInt(), it[3].toInt()) }
			val entry: WeatherEntry? =splitlines.minBy { it.max - it.min }
			entry!!.day shouldEqual "14"
		}
		"Find day with minimum temperature".invoke(lamda)
	}
}

data class WeatherEntry(val day: String, val max: Int, val min: Int)