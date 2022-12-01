package jb.aoc

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class DayOneTest {
    @Test
    fun `part 1 - most caloric elf`() {
        val mostCaloric = caloriesByElf(day1part1TestInput).mostCaloricElf()
        mostCaloric shouldBe 24000
    }

    @Test
    fun `part 2 - three most caloric elves`() {
        val mostCaloric = caloriesByElf(day1part1TestInput).threeMostCaloricElves()
        mostCaloric shouldBe 45000
    }

    @Test
    fun `day1 part1`() {
        Day1().part1() shouldBe 68775
    }

    @Test
    fun `day1 part2`() {
        Day1().part2() shouldBe 202585
    }
}

val day1part1TestInput = """1000
2000
3000

4000

5000
6000

7000
8000
9000

10000
"""

