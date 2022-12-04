package jb.aoc

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class DayFourTest {
    private val splitStrings = splitStrings("test", "day4")
    private val elfPairings: ElfPairings = splitStrings.shapeForDayFour()


    @Test
    fun `part 1 - find sections`() {
        val noOverlap = "2-3,4-5".pairSections()
        noOverlap.first.first shouldBe 2
        noOverlap.first.second shouldBe 3
        noOverlap.second.first shouldBe 4
        noOverlap.second.second shouldBe 5
    }

    @Test
    fun `part 1 - find overlapping sections`() {
        val noOverlap = "2-3,4-5".pairSections()
        val overlap = "25-27,27-29".pairSections()
        val consuming = "2-8,3-7".pairSections()

        overlap.overlapping() shouldBe true
        noOverlap.overlapping() shouldBe false
        noOverlap.consuming() shouldBe false
        consuming.consuming() shouldBe true
    }

    @Test
    fun `part 1 - number of completely overlapping assignments`() {
        elfPairings.allConsumingCount() shouldBe 2
    }

    @Test
    fun `part 2 - number of partially overlapping assignments`() {
        elfPairings.overlappingCount() shouldBe 4
    }

    @Test
    fun `day4 part1`() {
        val elfPairings = splitStrings(day = "day4").shapeForDayFour()
        elfPairings.count { it.consuming() } shouldBe 657
    }

    @Test
    fun `day4 part2`() {
        val elfPairings = splitStrings(day = "day4").shapeForDayFour()
        elfPairings.count { it.overlapping() } shouldBe 938
    }
}
