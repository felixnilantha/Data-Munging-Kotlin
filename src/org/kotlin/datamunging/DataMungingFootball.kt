package org.kotlin.datamunging

import java.io.File
import io.kotlintest.specs.StringSpec
import io.kotlintest.matchers.shouldEqual

class DataMungingFootballTests : StringSpec() {
	init {

		"smalles diffrent in for an agaist" {
			val entry: TeamEntry?= File("football.dat")
					.readLines()
					.drop(1).take(21)
					.filterNot { it.contains("--") }
					.map { it.split(Regex(" +")) }
					.map{ TeamEntry(it[2], it[7].toInt(), it[9].toInt())}
					.minBy { Math. abs(it.goalsFor - it.goalsAgainst) }
				
			entry?.name shouldEqual "Aston_Villa"
		}

	}
}

data class TeamEntry(val name: String, val goalsFor: Int, val goalsAgainst: Int)