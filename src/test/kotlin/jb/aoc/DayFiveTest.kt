package jb.aoc

import io.kotest.matchers.shouldBe
import jb.aoc.Crane.*
import jb.aoc.DayFive.Companion.movesFrom
import jb.aoc.DayFive.Companion.stacksFrom
import org.junit.jupiter.api.Test

class DayFiveTest {
    private val splitStrings = splitStrings("test", "day5", false)
    private val stacks = stacksFrom(splitStrings)

    @Test
    fun `part 1 - rack and stack em`() {
        stacks[0] shouldBe listOf("[Z]", "[N]")
        stacks[1] shouldBe listOf("[M]", "[C]", "[D]")
        stacks[2] shouldBe listOf("[P]")
    }

    @Test
    fun `part 1 - move`() {
        val aMove = listOf(DayFive.moveFrom("move 1 from 2 to 1"))

        Crane9000.arrange(stacks, aMove)
        stacks[0] shouldBe listOf("[Z]", "[N]", "[D]")
        stacks[1] shouldBe listOf("[M]", "[C]")
        stacks[2] shouldBe listOf("[P]")
    }

    @Test
    fun `part 1 - top of stacks`() {
        val stacks = stacksFrom(splitStrings)
        val moves = movesFrom(splitStrings)

        Crane9000.arrange(stacks, moves).topOfTheStacks() shouldBe "CMZ"
    }

    @Test
    fun `day 5 part 1 - Crane 9000`() {
        val inputs = splitStrings(day = "day5", shouldTrim = false)
        val stacks = stacksFrom(inputs)
        val moves = movesFrom(inputs)

        Crane9000.arrange(stacks, moves).topOfTheStacks() shouldBe "CNSZFDVLJ"
    }

    @Test
    fun `day 5 part 2 - Crane 9001`() {
        val inputs = splitStrings(day = "day5", shouldTrim = false)
        val stacks = stacksFrom(inputs)
        val moves = movesFrom(inputs)

        Crane9001.arrange(stacks, moves).topOfTheStacks() shouldBe "QNDWLMGNS"
    }
}
