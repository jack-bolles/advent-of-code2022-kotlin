package jb.aoc

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class DayThreeTest {
    private val rucksacks: List<List<Set<Char>>> = splitStrings("test", "day3").shapeForDayThree()

    @Test
    fun `part 1 - compare two sides of a rucksack`() {
        val line = "vJrwpWtwJgWrhcsFMMfFFhFp"
        run {
            val rucksack = line.shapeForDayThree()
            uniqueShareItem(rucksack).pointsFor()
        } shouldBe 16
    }

    @Test
    fun `part 1 - compare two sides of all rucksacks`(){
        rucksacks.totalScore() shouldBe 157
    }

    @Test
    fun `day3 part1`() = DayThree().part1() shouldBe 7817

//    @Test
//    fun `day3 part2`() = DayThree().part2() shouldBe ???
}