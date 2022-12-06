fun main() {
    val input = readInputText("day06/input")

    val day = Day06()

    //TestInput
    val testInput = listOf(
        "mjqjpqmgbljsphdztnvjfqwrcgsmlb",
        "bvwbjplbgvbhsrlpgdmjqwftvncz",
        "nppdvjthqldpwncqszvftbrmjlhg",
        "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg",
        "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"
    )

    testInput.forEach { x ->
        println("Part 1: ${day.part1(x)}")
    }

    testInput.forEach { x ->
        println("Part 2: ${day.part2(x)}")
    }

    println("Part 1: ${day.part1(input)}")
    println("Part 2: ${day.part2(input)}")
}

class Day06 {

    /**
     * Could have used
     * input.windowed(4, 1).indexOfFirst { it.toSet().size == it.size } + 4
     */
    private fun findStartOf(input: String, marker: Int): Int {
        var found = false
        var i = 0
        var result = 0

        while (!found && i < input.length - marker) {
            if (input.substring(i, i + marker).toSet().size == marker) {
                result = i + marker
                found = true
            }
            i++
        }

        return result
    }

    fun part1(input: String): Int = findStartOf(input, 4)

    fun part2(input: String): Int = findStartOf(input,14)
}