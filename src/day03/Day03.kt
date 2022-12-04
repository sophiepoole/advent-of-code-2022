package day03

import readInput

val priority: Map<Char, Int> = (('a'..'z' zip 1..26)  + ('A'..'Z' zip 27..52)).toMap()

fun main() {

    fun checkRucksack(rucksack: String): Int {
        val items = rucksack.toList()
        val n = items.size    // get the size of the list

        val compartment1 = items.subList(0, (n + 1) / 2)
        val compartment2 = items.subList((n + 1) / 2, n)

        val first = compartment1.intersect(compartment2).first()
        return priority[first] ?: 0
    }

    fun part1(input: List<String>): Int {
        return input.sumOf { checkRucksack(it) }
    }

    fun findBadges(rucksacks: List<List<Char>>): Int {
        val badge = rucksacks[0].intersect(rucksacks[1]).intersect(rucksacks[2]).first()
        return priority[badge] ?: 0

    }

    fun part2(input: List<String>): Int {
        return input
            .map{ it.toList()}
            .chunked(3)
            .sumOf { findBadges(it) }
    }


    val testInput = readInput("day03/input_test")
    println("----------Test----------")
    println("Part 1: ${part1(testInput)}")
    println("Part 2: ${part2(testInput)}")

    val input = readInput("day03/input")
    println("----------Input----------")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}
