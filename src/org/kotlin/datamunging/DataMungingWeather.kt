package org.kotlin.datamunging

import java.io.File
import io.kotlintest.specs.StringSpec
import io.kotlintest.matchers.shouldEqual

// this comment was left before refactoring
/// this is the code before refactring will be commited for reference purpose to
/// whome need to understand lamda

//======= refactored code
class DataMungingWeatherTests : StringSpec() {
	init {
		
		"Find day with min temperature" {
			val entry : WeatherEntry? = File("weather.dat")
					.readLines()
					.drop(2)
					.take(30)
					.map { it.replace("*", "").split(Regex(" +")) }
					.map { WeatherEntry(it[1], it[2].toInt(), it[3].toInt()) }
					.minBy { it.max - it.min }
			
			entry?.day shouldEqual "14" 
		}
		
		
		
	}
}

data class WeatherEntry(val day: String, val max: Int, val min: Int)