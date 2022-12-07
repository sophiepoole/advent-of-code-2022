package day07

import readInput

fun main() {
//    val input = readInput("day07/input_test")
    val input = readInput("day07/input")
    val day = Day07()

    val fileSystem = day.parse(input)

    println("Part 1: ${day.part1(fileSystem)}")
    println("Part 2: ${day.part2(fileSystem)}")
}

sealed class Component

data class File(val name: String, val size: Int) : Component()

class Directory(
    var name: String,
    var parent: Directory? = null,
    var children: MutableMap<String, Component> = mutableMapOf(),
    var size: Int = 0
) : Component() {
    fun updateSize(a : Int){
        size += a
        parent?.updateSize(a)
    }
}

class Day07 {

    val totalSize = 70000000
    val updateSize = 30000000

    fun parse(input: List<String>): MutableList<Directory> {
        val root = Directory("/")
        var current = root
        val allDirectories = mutableListOf(root)

        for (line in input) {
            val split = line.split(" ")
            if (split[0] == "$") {
                if (split[1] == "cd") {
                    current = when (split[2]) {
                        ".." -> current.parent!!
                        "/" -> root
                        else -> {
                            current.children[split[2]] as Directory
                        }
                    }
                }
            } else if (split[0] == "dir") {
                val directory = Directory(split[1], parent = current)
                current.children[split[1]] = directory
                allDirectories.add(directory)
            } else {
                current.children[split[0]] = File(split[1], split[0].toInt())
                current.updateSize(split[0].toInt())
            }
        }

        return allDirectories
    }

    fun part1(allDirectories: List<Directory>): Int {
        return allDirectories.filter { it.size <= 100000 }.sumOf { it.size }
    }

    fun part2(allDirectories: List<Directory>): Int {
         val freeSpace = 70000000 - allDirectories.first { it.name == "/" }.size
         val toFind = 30000000 - freeSpace

        return allDirectories.filter { it.size >= toFind }.minOf { it.size }
    }
}