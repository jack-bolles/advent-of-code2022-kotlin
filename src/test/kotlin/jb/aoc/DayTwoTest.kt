package jb.aoc

import io.kotest.matchers.shouldBe
import jb.aoc.RSP.Companion.play
import org.junit.jupiter.api.Test

class DayTwoTest {
    private val contest = contest(testInputs("day2"))

    @Test
    fun `part 1 - rochambeau - rock beats scissors`() {
        val rockVsPaper = contest.first()
        rockVsPaper.play() shouldBe 8
    }

    @Test
    fun `part 1 - rochambeau - total score`() {
        contest.totalScore() shouldBe 15
    }

    @Test
    fun `day2 part1`() = DayTwo().part1() shouldBe 10994

}


