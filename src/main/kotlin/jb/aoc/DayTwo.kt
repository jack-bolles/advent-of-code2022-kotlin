package jb.aoc

import jb.aoc.RSP.Companion.play

class DayTwo {
    private val input = inputs("day2")
    private val contest = contest(input)

    fun part1(): Int {
        return contest.totalScore()
    }

    fun part2() {
        TODO("Not yet implemented")
    }
}

typealias Rochambeau = Pair<RSP, RSP>
typealias Contest = List<Rochambeau>

fun Contest.totalScore(): Int = sumOf { it.play() }

fun contest(input: String): List<Rochambeau> =
    input.trim().split("\n")
        .map { it.split(" ") }
        .map { Pair(RSP.from(it.first()), RSP.from(it.last())) }

enum class RSP {
    ROCK { override fun versus(other: RSP): Int = score(other, 1, PAPER, SCISSORS) },
    PAPER { override fun versus(other: RSP): Int = score(other, 2, SCISSORS, ROCK) },
    SCISSORS { override fun versus(other: RSP): Int = score(other, 3, ROCK, PAPER) };

    abstract fun versus(other: RSP): Int

    companion object {
        private fun RSP.score(other: RSP, score: Int, losesTo: RSP, beats: RSP) =
            score + when (other) {
                this -> 3
                losesTo -> 0
                beats -> 6
                else -> {
                    throw IllegalArgumentException("huh: $other ?")
                }
            }

        fun Rochambeau.play() =
            second.versus(first)

        fun from(key: String): RSP = when (key) {
            "A", "X" -> ROCK
            "B", "Y" -> PAPER
            "C", "Z" -> SCISSORS
            else -> throw IllegalArgumentException("what is this: $key ?")
        }
    }
}
