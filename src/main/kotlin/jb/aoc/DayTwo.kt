package jb.aoc

class DayTwo {
    private val inputs: SplitInputs = splitStrings(day = "day2").shapeForDayTwo()
    fun part1(): Int = contest(inputs, ::partOneParser).totalOfPriorities()    //.also { println(it) }
    fun part2(): Int = contest(inputs, ::partTwoParser).totalOfPriorities()    //.also { println(it) }
}

fun List<String>.shapeForDayTwo(): SplitInputs = map { it.split(" ") }

typealias Contest = List<Rochambeau>
fun Contest.totalOfPriorities(): Int = sumOf { it.play() }
val contest: (SplitInputs, Parser) -> Contest =
    { splitInputs, parser -> splitInputs.map { parser(it) } }

typealias Rochambeau = Pair<RSP, RSP>
fun Rochambeau.play() = second.versus(first)

typealias Parser = (List<String>) -> Rochambeau

fun partOneParser(it: List<String>): Rochambeau = Rochambeau(RSP.from(it.first()), RSP.from(it.last()))
fun partTwoParser(strings: List<String>): Rochambeau {
    val opponentThrow = RSP.from(strings.first())
    val desiredResult = strings.last()
    val myThrow = opponentThrow.throwFor(desiredResult)
    return Rochambeau(opponentThrow, myThrow)
}


enum class RSP {
    ROCK {
        override fun versus(other: RSP): Int = score(other, 1, PAPER, SCISSORS)
        override fun throwFor(desiredResult: String): RSP = chooseThrow(desiredResult, PAPER, SCISSORS)
    },
    PAPER {
        override fun versus(other: RSP): Int = score(other, 2, SCISSORS, ROCK)
        override fun throwFor(desiredResult: String): RSP = chooseThrow(desiredResult, SCISSORS, ROCK)
    },
    SCISSORS {
        override fun versus(other: RSP): Int = score(other, 3, ROCK, PAPER)
        override fun throwFor(desiredResult: String): RSP = chooseThrow(desiredResult, ROCK, PAPER)
    };

    abstract fun versus(other: RSP): Int
    abstract fun throwFor(desiredResult: String): RSP

    companion object {
        fun RSP.chooseThrow(desiredResult: String, toWin: RSP, toLose: RSP): RSP
            = when (desiredResult) {
                "X" -> toLose
                "Y" -> this
                "Z" -> toWin
                else -> throw IllegalArgumentException("huh: $desiredResult ?")
            }

        private fun RSP.score(other: RSP, score: Int, losesTo: RSP, beats: RSP): Int
            = score + when (other) {
                this -> 3
                losesTo -> 0
                beats -> 6
                else -> throw IllegalArgumentException("huh: $other ?")
        }

        fun from(key: String): RSP
            = when (key) {
                "A", "X" -> ROCK
                "B", "Y" -> PAPER
                "C", "Z" -> SCISSORS
                else -> throw IllegalArgumentException("what is this: $key ?")
        }
    }
}
