package jb.aoc

class DayThree {
    private val rucksacks: RuckSacks = splitStrings(day ="day3").shapeForDayThree()
    fun part1() = rucksacks.totalScore()    //.also { println(it) }
//    fun part2() = rucksacks    //.also { println(it) }
}

typealias RuckSacks = List<List<Set<Char>>>

fun List<String>.shapeForDayThree(): RuckSacks = this.map { it.shapeForDayThree() }

fun String.shapeForDayThree() =
    chunked(length / 2)
    .map { it.toCharArray().toSet() }

fun RuckSacks.totalScore() =
    map { uniqueShareItem(it) }
    .sumOf { it.pointsFor() }

fun uniqueShareItem(rucksack: List<Set<Char>>) =
    rucksack[0].intersect(rucksack[1].toSet()).first()

fun Char.pointsFor() = alphabet.indexOf(this) + 1

private val alphabet = ('a'..'z').toList() + ('A'..'Z').toList()
