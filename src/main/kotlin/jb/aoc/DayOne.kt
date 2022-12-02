package jb.aoc

class DayOne {
    private val inputs: SplitInputs = splitStrings(day = "day1").shapeForDayOne()
    fun part1(): Int = caloriesByElf(inputs).mostCaloricElf() //.also { println(it) }
    fun part2(): Int = caloriesByElf(inputs).threeMostCaloricElves() //.also { println(it) }
}

fun List<Int>.mostCaloricElf(): Int = max()
fun List<Int>.threeMostCaloricElves(): Int = sortedDescending().take(3).sum()

fun caloriesByElf(joinedLines: List<List<String>>): List<Int> =
    joinedLines.map { list -> list.sumOf { it.toInt() } }  //.also { println(it) }

fun List<String>.shapeForDayOne() = joinToString(prefix = "", postfix = "", separator = "!")
    { it.ifBlank { "??" } }.split("??")
    .map { it.split("!") }
    .map { it.filter(String::isNotBlank) }
