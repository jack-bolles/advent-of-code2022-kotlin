package jb.aoc

import java.io.File

fun main() {
    Day1().part1()
    Day1().part2()
}

class Day1 {
    private val input = readInputAsText("day1")
    private val caloriesByElf = caloriesByElf(input)

    fun part1(): Int {
        return caloriesByElf.mostCaloricElf().also { println(it) }
    }

    fun part2(): Int {
        return caloriesByElf.threeMostCaloricElves().also { println(it) }
    }
}

fun List<Int>.mostCaloricElf(): Int = max()
fun List<Int>.threeMostCaloricElves(): Int = sortedDescending().take(3).sum()

fun caloriesByElf(input: String): List<Int> {
    val joinedLines: String = input.split("\n")
        .joinToString(prefix = "", postfix = "", separator = "!")
        { it.ifBlank { "??" } }

    return joinedLines.split("??")
        .map { it.split("!") }
        .map { it.filter(String::isNotBlank) }
        .map { list -> list.sumOf { it.toInt() } }
//        .also { println(it) }
}


fun readInputAsText(name: String) = File("""src/main/kotlin/jb/aoc/""", "$name-input.txt").readText()