package jb.aoc

import io.kotest.matchers.shouldBe
import jb.aoc.DayFive.Companion.moves
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
        stacks.arrange9000(aMove)
        stacks[0] shouldBe listOf("[Z]", "[N]", "[D]")
        stacks[1] shouldBe listOf("[M]", "[C]")
        stacks[2] shouldBe listOf("[P]")
    }

    @Test
    fun `part 1 - top of stacks`() {
        stacks.arrange9000(moves(splitStrings)) shouldBe "CMZ"
    }

    @Test
    fun `day 5 part 1 - Crane 9000`() {
        val inputs = splitStrings(day = "day5", shouldTrim = false)
        val stacks = stacks(inputs)
        val moves = moves(inputs)

        stacks.arrange9000(moves).topOfTheStacks() shouldBe "CNSZFDVLJ"
    }

    @Test
    fun `day 5 part 2 - Crane 9001`() {
        val inputs = splitStrings(day = "day5", shouldTrim = false)
        val stacks = stacks(inputs)
        val moves = moves(inputs)

        stacks.arrange9001(moves).topOfTheStacks() shouldBe "QNDWLMGNS"
    }
}
