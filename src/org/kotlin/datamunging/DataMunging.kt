package org.kotlin.datamunging

import java.io.File
import io.kotlintest.specs.StringSpec

class DataMunging : StringSpec() {
	init {
		val lamda: () -> Unit = {
			val lines: List<String> = File("weather.dat").readLines().drop(2).take(30)
			val splitlines: List <List<Any>> = lines.map { it.replace("*", "").split(Regex(" +")) }
					.map { listOf(it[1], it[2].toInt(), it[3].toInt())}
		
			splitlines.forEach { println(it) }
		}
		"Find day with minimum temperature".invoke(lamda)
	}
}
