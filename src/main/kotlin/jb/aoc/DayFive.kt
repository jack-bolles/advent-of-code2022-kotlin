package jb.aoc

import jb.aoc.Crane.*


class DayFive {
    private val inputs: List<String> = splitStrings(day = "day5")
    private val stacks = stacks(inputs)
    private val moves = moves(inputs)

    fun part1(): String = Crane9000().arrange(stacks, moves).topOfTheStacks() //.also { println(it) }
    fun part2(): String = Crane9001().arrange(stacks, moves).topOfTheStacks() //.also { println(it) }

    companion object {
        fun stacks(inputs: List<String>): Array<List<String>> {
            fun pivot(stacks: List<List<String>>): Array<List<String>> {
                val numberOfStacks = stacks.maxOfOrNull { it: List<String> -> it.size }!!
                val arrayOfStacks = Array(numberOfStacks) { emptyList<String>() }

                stacks.forEach { aStack ->
                    aStack.forEachIndexed { i, v ->
                        if (v.isNotBlank()) arrayOfStacks[i] = arrayOfStacks[i].plus(v)
                    }
                }
                return arrayOfStacks
            }

            val stackLines: List<List<String>> = inputs
                .filter { it: String -> it.contains("[") }
                .map { it: String -> it.chunked(4).map { it.trim() } }
                .reversed()
            return pivot(stackLines)
        }

        fun moves(splitStrings: List<String>) = splitStrings.filter { it.startsWith("move") }.map { move(it) }

        fun move(raw: String): Move {
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

interface Crane {
    fun arrange(stacks: Stacks, moves: List<Move>): Stacks
    class Crane9000 :Crane {
        override fun arrange(stacks: Stacks, moves: List<Move>): Stacks {
            moves.forEach { stacks.makeMove9000(it) }
            return stacks
        }
    }
    class Crane9001 : Crane {
        override fun arrange(stacks: Stacks, moves: List<Move>): Stacks {
            moves.forEach { stacks.makeMove9001(it) }
            return stacks
        }
    }
}

fun Stacks.topOfTheStacks(): String {
    return this.map { it.lastOrNull() }
        .joinToString("")
        .replace("[", "").replace("]", "")
}

private fun Stacks.makeMove9000(move: Move): Array<List<String>> {
    val (numberToMove, fromStack, toStack) = move
    val chunks: List<String> = this[fromStack].takeLast(numberToMove).reversed()
    this[fromStack] = this[fromStack].dropLast(numberToMove)
    this[toStack] = this[toStack] + chunks
    return this
}

fun Array<List<String>>.makeMove9001(move: Move): Array<List<String>> {
    val (numberToMove, fromStack, toStack) = move
    val chunks: List<String> = this[fromStack].takeLast(numberToMove)
    this[fromStack] = this[fromStack].dropLast(numberToMove)
    this[toStack] = this[toStack] + chunks
    return this
}

