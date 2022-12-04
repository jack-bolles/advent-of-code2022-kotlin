package jb.aoc

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class DayFourTest {
    private val splitStrings = splitStrings("test", "day4")

    @Test
    fun `part 1 - find sections`() {
        val noOverlap = "2-3,4-5".pairOfSections()


        println(noOverlap)
        noOverlap.first.first shouldBe 2
        noOverlap.first.second shouldBe 3
        noOverlap.second.first shouldBe 4
        noOverlap.second.second shouldBe 5
    }

    @Test
    fun `part 1 - find overlapping sections`() {
        val noOverlap = "2-3,4-5".pairOfSections()
        val overlap = "25-27,27-29".pairOfSections()
        overlap.second.first shouldBe 27
        overlap.first.second shouldBe 27

        overlap.overlapping() shouldBe true
        noOverlap.overlapping() shouldBe false
    }

    @Test
    fun `part 1 - number of completely overlapping assignments`() {
        val elfPairings = splitStrings
        elfPairings.map { it.pairOfSections().consuming() }.count { it } shouldBe 2
    }

    @Test
    fun `part 2 - number of partially overlapping assignments`() {
        val elfPairings = splitStrings
        elfPairings.map { it.pairOfSections().overlapping() }.count { it } shouldBe 4
    }

    @Test
    fun `day4 part1`() {
        val elfPairings = splitStrings(day = "day4")
        elfPairings.map { it.pairOfSections() }.count { it.consuming() } shouldBe 657
    }

    @Test
    fun `day4 part2`() {
        val elfPairings = splitStrings(day = "day4")
        elfPairings.map { it.pairOfSections().overlapping() }.count { it } shouldBe 938
    }

    private fun Pair<Pair<Int, Int>, Pair<Int, Int>>.overlapping(): Boolean {
        val firstRange = first.first..first.second
        val secondRange = second.first..second.second
        return (first.first in secondRange || first.second in secondRange)
                || (second.first in firstRange || second.second in firstRange)

    }

    private fun Pair<Pair<Int, Int>, Pair<Int, Int>>.consuming(): Boolean {
        val firstRange = first.first..first.second
        val secondRange = second.first..second.second
        return (first.first in secondRange && first.second in secondRange)
                || (second.first in firstRange && second.second in firstRange)

    }

    private fun String.pairOfSections() =
        split(",").map { line -> sectionRange(line) }.let { (start, end) -> start to end }

    private fun sectionRange(line: String): Pair<Int, Int> =
        line.split("-").let { (start, end) -> start.toInt() to end.toInt() }

}