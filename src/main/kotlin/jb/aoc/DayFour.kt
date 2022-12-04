package jb.aoc

class DayFour {
    private val elfPairings: ElfPairings = splitStrings(day = "day1").shapeForDayFour()
    fun part1(): Int = elfPairings.allConsumingCount() //.also { println(it) }
    fun part2(): Int = elfPairings.overlappingCount() //.also { println(it) }
}

typealias Section = Pair<Int, Int>
typealias Sections = Pair<Section, Section>
typealias ElfPairings = List<Sections>

fun ElfPairings.allConsumingCount() = count { it.consuming() }
fun ElfPairings.overlappingCount() = count { it.consuming() }

fun List<String>.shapeForDayFour() = map { it.pairSections() }
fun String.pairSections() = split(",")
    .map { line -> sectionRange(line) }
    .let { (start, end) -> start to end }

fun sectionRange(line: String): Pair<Int, Int> = line
    .split("-")
    .let { (start, end) -> start.toInt() to end.toInt() }

fun Sections.overlapping(): Boolean = first.overlaps(second) || second.overlaps(first)

fun Section.overlaps(second: Section): Boolean {
    val firstRange = this.first..this.second
    return (second.first in firstRange || second.second in firstRange)
}

fun Sections.consuming(): Boolean = first.consumes(second) || second.consumes(first)

fun Section.consumes(second: Section): Boolean {
    val firstRange = this.first..this.second
    return (second.first in firstRange && second.second in firstRange)
}
