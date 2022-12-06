package day05

import readInputText

fun main() {
    val testInput = readInputText("day05/input_test")
    val input = readInputText("day05/input")

    val day = Day05()

    println("Part 1: ${day.part1(testInput)}")
    println("Part 2: ${day.part2(testInput)}")
    println("Part 1: ${day.part1(input)}")
    println("Part 2: ${day.part2(input)}")
}

data class Move(val amount: Int, val from: Int, val to: Int) {
    companion object {
        private val regex = Regex("[0-9]+")

        fun getFromString(move: String): Move {
            val numbers =  regex.findAll(move)
                .map(MatchResult::value)
                .toList()

            return Move(numbers[0].toInt(), numbers[1].toInt(), numbers[2].toInt())
        }
    }

}

class Day05 {

    private fun getMoves(input: String): List<Move> {
        return input.split("\n\n")[1]
            .split("\n")
            .map { Move.getFromString(it) }
    }

    private fun getStacks(input: String): List<MutableList<Char>> {
        val split = input.split("\n\n")

        val numberOfCrates = split[0].last().digitToInt()
        val stacks = List(numberOfCrates) { mutableListOf<Char>() }

        val crates = split[0].split("\n").dropLast(1).asReversed()

        crates.map { it.chunked(4) }.forEach { window ->
            run {
                window.forEachIndexed { index, element ->
                    val crateLabel = element.toList()[1]
                    if (crateLabel != ' ') {
                        stacks[index].add(crateLabel)
                    }
                }
            }
        }

        return stacks
    }

    fun part1(input: String): String {
        val moves = getMoves(input)
        val stacks = getStacks(input)

        moves.forEach { move ->
            for (i in 1..move.amount) {
                val crate = stacks[move.from-1].removeLast()
                stacks[move.to-1].add(crate)
            }
        }

        var result = ""
        for(stack in stacks) {
            result += stack.last()
        }

        return stacks.fold("") { acc, string -> acc + string.last() }
    }

    fun part2(input: String): String {
        val moves = getMoves(input)
        val stacks = getStacks(input)

        moves.forEach { move ->
            val crates = stacks[move.from-1].takeLast(move.amount)
            for (i in 1..move.amount) {
                stacks[move.from-1].removeLast()
            }

            stacks[move.to-1].addAll(crates)
        }

        return stacks.fold("") { acc, string -> acc + string.last() }
    }
}