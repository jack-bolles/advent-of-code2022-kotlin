package jb.aoc

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class DayOneTest {
    private val caloriesByElf = caloriesByElf(testInputs("day1"))

    @Test
    fun `part 1 - most caloric elf`() {
        caloriesByElf.mostCaloricElf() shouldBe 24000
    }

    @Test
    fun `part 2 - three most caloric elves`() {
        caloriesByElf.threeMostCaloricElves() shouldBe 45000
    }

    @Test
    fun `day1 part1`() = DayOne().part1() shouldBe 68775

    @Test
    fun `day1 part2`() = DayOne().part2() shouldBe 202585
}

