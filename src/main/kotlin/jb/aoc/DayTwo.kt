package jb.aoc

import jb.aoc.RSP.Companion.play
import java.lang.IllegalArgumentException

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

typealias Rochambeau= Pair<RSP, RSP>
typealias Contest = List<Rochambeau>

fun Contest.totalScore(): Int {
    return sumOf { it.play() }
}

fun contest(input: String): List<Rochambeau> =
    input.trim().split("\n")
    .map { it.split(" ") }
    .map { Pair(RSP.from(it.first()), RSP.from(it.last())) }

enum class RSP {
    ROCK {
        override fun versus(other: RSP): Int {
            return 1 + when (other) {
                ROCK -> 3
                PAPER -> 0
                SCISSORS -> 6
            }
        }
    },
    PAPER {
        override fun versus(other: RSP): Int {
            return 2 + when (other) {
                ROCK -> 6
                PAPER -> 3
                SCISSORS -> 0
            }
        }
    },
    SCISSORS {
        override fun versus(other: RSP): Int {
            return 3 + when (other) {
                ROCK -> 0
                PAPER -> 6
                SCISSORS -> 3
            }
        }
    };

    abstract fun versus(other: RSP): Int

    companion object {
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
