package day04

import readInput

fun main() {

    fun getRange(a: String): IntRange {
        val split = a.split("-")
        return split[0].toInt()..split[1].toInt()
    }

    fun checkPair(pair: String): Int {
        val split = pair.split(",")
        val a = getRange(split[0])
        val b = getRange(split[1])

        val intersect = a.intersect(b)

        return if (intersect.size == a.count() || intersect.size == b.count()) { 1 }
        else { 0 }

    }

    fun part1(input: List<String>): Int {
        return input.sumOf { checkPair(it) }
    }

    fun checkPair2(pair: String): Int {
        val split = pair.split(",")
        val a = getRange(split[0])
        val b = getRange(split[1])

        val intersect = a.intersect(b)

        return if (intersect.isNotEmpty()) { 1 }
        else { 0 }

    }

    fun part2(input: List<String>): Int {
        return input.sumOf { checkPair2(it) }
    }


    val testInput = readInput("day04/input_test")
    println("----------Test----------")
    println("Part 1: ${part1(testInput)}")
    println("Part 2: ${part2(testInput)}")

    val input = readInput("day04/input")
    println("----------Input----------")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}
