package jb.aoc

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class DayTwoTest {
    private val inputs = splitStrings("test", "day2").shapeForDayTwo()

    private val contestPartOne = contest(inputs, ::partOneParser)
    private val contestPartTwo = contest(inputs, ::partTwoParser)

    @Test
    fun `part 1 - rochambeau - rock beats scissors`() {
        val rockVsPaper = contestPartOne.first()
        rockVsPaper.play() shouldBe 8
    }

    @Test
    fun `part 1 - rochambeau - total score`() {
        contestPartOne.totalScore() shouldBe 15
    }

    @Test
    fun `part 2 - choose throw by desired result`() {
        val rockVsPaper = contestPartTwo.first()
        rockVsPaper.play() shouldBe 4
    }

    @Test
    fun `part 2 - rochambeau - total score`() {
        contestPartTwo.totalScore() shouldBe 12
    }

    @Test
    fun `day2 part1`() = DayTwo().part1() shouldBe 10994

    @Test
    fun `day2 part2`() = DayTwo().part2() shouldBe 12526

}


