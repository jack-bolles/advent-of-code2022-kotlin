package jb.aoc

class DayThree {
    private val inputs = splitStrings(day = "day3")
    fun part1() = inputs.compartmentaliseRucksacks().totalOfPriorities()    //.also { println(it) }
    fun part2() = inputs.prioritiseGroups()    //.also { println(it) }
}

typealias RuckSacks = List<RuckSack>
typealias RuckSack = List<Set<Char>>

fun List<String>.compartmentaliseRucksacks(): RuckSacks =
    map {it.chunked(it.length / 2).map { it.toCharArray().toSet() } }

fun String.compartmentaliseRucksack() =
    chunked(length / 2).map { it.toCharArray().toSet() }

fun RuckSacks.totalOfPriorities() =
    map { it[0].intersect(it[1].toSet()).first() }.sumOf { it.priority() }

fun Char.priority() = alphabet.indexOf(this) + 1

fun RuckSack.uniqueShareItem() =
    this[0].intersect(this[1].toSet()).first()

private val alphabet = ('a'..'z').toList() + ('A'..'Z').toList()

fun List<String>.prioritiseGroups(): Int =
    chunked(3)
        .map { it: List<String> -> it.toSet().priority() }.sumOf { it }

fun Set<String>.priority(): Int = badge().priority()

private fun Set<String>.badge(): Char {
    val group = map { it.toCharArray().toSet() }
    return group[0].intersect(group[1]).intersect(group[2]).first()
}
