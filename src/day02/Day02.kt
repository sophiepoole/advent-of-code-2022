package day02

import readInput

fun main() {

//    A/X = 1 = Rock
//    B/Y = 2 = Paper
//    C/Z = 3 = Scissors
//    0 loss(X) 3 draw(Y) 6 for win(Z)

    fun part1GetScore(round: Pair<Char, Char>) =
        when (round) {
            'A' to 'X' -> 4
            'A' to 'Y' -> 8
            'A' to 'Z' -> 3
            'B' to 'X' -> 1
            'B' to 'Y' -> 5
            'B' to 'Z' -> 9
            'C' to 'X' -> 7
            'C' to 'Y' -> 2
            'C' to 'Z' -> 6
            else -> 0
        }

    fun part1(input: List<String>): Int = input.map { it[0] to it[2] }.sumOf { part1GetScore(it) }

    fun part2GetScore(round: Pair<Char, Char>) =
        when (round) {
            'A' to 'X' -> 3
            'A' to 'Y' -> 4
            'A' to 'Z' -> 8
            'B' to 'X' -> 1
            'B' to 'Y' -> 5
            'B' to 'Z' -> 9
            'C' to 'X' -> 2
            'C' to 'Y' -> 6
            'C' to 'Z' -> 7
            else -> 0
        }

    fun part2(input: List<String>): Int = input.map { it[0] to it[2] }.sumOf { part2GetScore(it) }


    val testInput = readInput("day02/input_test")
    println("----------Test----------")
    println("Part 1: ${part1(testInput)}")
    println("Part 2: ${part2(testInput)}")

    val input = readInput("day02/input")
    println("----------Input----------")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}
