package jb.aoc

import io.kotest.matchers.shouldBe
import jb.aoc.DayFive.Companion.stacks
import org.junit.jupiter.api.Test

class DayFiveTest {
    private val splitStrings = splitStrings("test", "day5", false)
    private val stacks = stacks(splitStrings)

    @Test
    fun `part 1 - rack and stack em`() {
        stacks[0] shouldBe listOf("[Z]", "[N]")
        stacks[1] shouldBe listOf("[M]", "[C]", "[D]")
        stacks[2] shouldBe listOf("[P]")
    }

    @Test
    fun `part 1 - move`() {
        val aMove = listOf(DayFive.move("move 1 from 2 to 1"))
        stacks.arrange(aMove)
        stacks[0] shouldBe listOf("[Z]", "[N]", "[D]")
        stacks[1] shouldBe listOf("[M]", "[C]")
        stacks[2] shouldBe listOf("[P]")
    }

    @Test
    fun `part 1 - top of stacks`() {
        stacks.arrange(DayFive.moves(splitStrings)) shouldBe "CMZ"
    }

    @Test
    fun `day 5 part 1 - top of the stacks`() {
        val inputs = splitStrings(day = "day5", shouldTrim = false)
        val stacks = stacks(inputs)
        val moves = DayFive.moves(inputs)

        stacks.arrange(moves) shouldBe "CNSZFDVLJ"
    }
}
