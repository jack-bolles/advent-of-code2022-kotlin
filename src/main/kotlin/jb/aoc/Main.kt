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

fun inputs(name: String, branch: String = "main") = File("src/$branch/kotlin/jb/aoc/", "$name-input.txt").readText()