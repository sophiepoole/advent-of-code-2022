package day01

import readInputText

fun main() {
    fun part1(input: String): Int =
        input
            .split("\n\n")
            .map { it.lines().map(String::toInt) }
            .maxOf { it.sum() }

    fun part2(input: String): Int =
        input
            .split("\n\n")
            .map { it.lines().map(String::toInt) }
            .map { it.sum() }
            .sortedDescending()
            .take(3)
            .sum()


    val testInput = readInputText("day01/input_test")
    println("----------Test----------")
    println("Part 1: ${part1(testInput)}")
    println("Part 2: ${part2(testInput)}")

    val input = readInputText("day01/input")
    println("----------Input----------")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}
