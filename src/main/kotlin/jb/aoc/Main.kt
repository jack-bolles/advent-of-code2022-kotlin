package jb.aoc

import java.io.File

fun main() {
    DayOne().run {
        part1()
        part2()
    }

    DayTwo().run {
        part1()
        part2()
    }
}


typealias SplitInputs = List<List<String>>

fun splitStrings(branch: String = "main", day: String) =
    inputs(branch = branch, day = day).split("\n")

private fun inputs(branch: String = "main", day: String) =
    File("src/$branch/kotlin/jb/aoc/", "$day-input.txt").readText().trim()
