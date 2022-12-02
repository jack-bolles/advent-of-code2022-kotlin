package jb.aoc

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import java.io.File

class DayOneTest {
    @Test
    fun `part 1 - most caloric elf`() {
        val mostCaloric = caloriesByElf(inputs("day1")).mostCaloricElf()
        mostCaloric shouldBe 24000
    }

    @Test
    fun `part 2 - three most caloric elves`() {
        val mostCaloric = caloriesByElf(inputs("day1")).threeMostCaloricElves()
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

fun inputs (name: String) = File("""src/test/kotlin/jb/aoc/""", "$name-input.txt").readText()

