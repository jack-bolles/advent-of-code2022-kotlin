package jb.aoc

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class DayThreeTest {
    val splitStrings = splitStrings("test", "day3")
    private val rucksacks: List<List<Set<Char>>> = splitStrings.compartmentaliseRucksacks()

    @Test
    fun `part 1 - compare two sides of a rucksack`() {
        val line = "vJrwpWtwJgWrhcsFMMfFFhFp"
        line.compartmentaliseRucksack().uniqueShareItem().priority() shouldBe 16
    }

    @Test
    fun `part 1 - compare two sides of all rucksacks`(){
        rucksacks.totalOfPriorities() shouldBe 157
    }

    @Test
    fun `part 2 - badge for a group`() {
        setOf(
            "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
            "ttgJtRGJQctTZtZT",
            "CrZsJsPPZsGzwwsLwLmpwMDw"
        ).priority()  shouldBe 52
    }

    @Test
    fun `part 2 - badge for all groups`() {
        splitStrings.prioritiseGroups() shouldBe 70
    }

    @Test
    fun `day3 part1`() = DayThree().part1() shouldBe 7817

    @Test
    fun `day3 part2`() = DayThree().part2() shouldBe 2444
}