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

fun splitStrings(branch: String = "main", day: String, shouldTrim: Boolean = true) =
    inputs(branch = branch, day = day, shouldTrim = shouldTrim).split("\n")

private fun inputs(branch: String = "main", day: String, shouldTrim: Boolean = true): String {
    val text = File("src/$branch/kotlin/jb/aoc/", "$day-input.txt").readText()
    return if (shouldTrim) text.trim() else text
}
