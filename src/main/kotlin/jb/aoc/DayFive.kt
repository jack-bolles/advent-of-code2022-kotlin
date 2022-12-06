package jb.aoc

import jb.aoc.Crane.*


class DayFive {
    private val inputs: List<String> = splitStrings(day = "day5")
    private val stacks = stacksFrom(inputs)
    private val moves = movesFrom(inputs)

    fun part1(): String = Crane9000.arrange(stacks, moves).topOfTheStacks() //.also { println(it) }
    fun part2(): String = Crane9001.arrange(stacks, moves).topOfTheStacks() //.also { println(it) }

    companion object {
        fun stacksFrom(inputs: List<String>): Stacks {
            fun pivot(rawLines: List<List<String>>): Stacks {
                val numberOfStacks = rawLines.maxOfOrNull { it: List<String> -> it.size }!!
                val arrayOfStacks = Array(numberOfStacks) { emptyList<String>() }

                rawLines.forEach { aStack ->
                    aStack.forEachIndexed { i, v ->
                        if (v.isNotBlank()) arrayOfStacks[i] = arrayOfStacks[i].plus(v)
                    }
                }
                return arrayOfStacks
            }

            val rawLines: List<List<String>> = inputs
                .filter { it: String -> it.contains("[") }
                .map { it: String -> it.chunked(4).map { it.trim() } }
                .reversed()
            return pivot(rawLines)
        }

        fun movesFrom(splitStrings: List<String>) = splitStrings
                .filter { it.startsWith("move") }
                .map { moveFrom(it) }

        fun moveFrom(raw: String): Move {
            val split = raw.split(" ")
            val numberToMove = split[1].toInt()
            val fromStack = split[3].toInt() - 1
            val toStack = split[5].toInt() - 1
            return Triple(numberToMove, fromStack, toStack)
        }
    }
}

typealias Stacks = Array<Stack>
typealias Stack = List<String>
typealias Move = Triple<Int, Int, Int>

sealed interface Crane {
    fun arrange(stacks: Stacks, moves: List<Move>): Stacks {
        moves.forEach { makeMove(stacks, it) }
        return stacks
    }

    fun makeMove(stacks: Stacks, move: Move): Stacks {
        val (numberToMove, fromStack, toStack) = move
        stacks[toStack] = stacks[toStack] + extractCrates(stacks[fromStack], numberToMove)
        stacks[fromStack] = stacks[fromStack].dropLast(numberToMove)
        return stacks
    }

    fun extractCrates(takeFrom: Stack, numberToMove: Int): List<String>

    object Crane9000 : Crane {
        override fun extractCrates(takeFrom: Stack, numberToMove: Int) =
            takeFrom.takeLast(numberToMove).reversed()
    }

    object Crane9001 : Crane {
        override fun extractCrates(takeFrom: Stack, numberToMove: Int) =
            takeFrom.takeLast(numberToMove)
    }
}

fun Stacks.topOfTheStacks(): String {
    return this.map { it.lastOrNull() }
        .joinToString("")
        .replace("[", "").replace("]", "")
}
