import java.util.*

fun main() {
    fun part1(input: Pair<Map<Int, ArrayDeque<Char>>, List<Triple<Int, Int, Int>>>): String {
        val stackMap = input.first
        val commands = input.second

        commands.forEach {
            for (i in 0 until it.first) {
                val firstEl = stackMap[it.second - 1]?.pop()
                if (firstEl != null) {
                    stackMap[it.third - 1]?.push(firstEl)
                }
            }
        }
        return stackMap.map { it.value.pop() }.joinToString("")
    }

    fun part2(input: Pair<Map<Int, ArrayDeque<Char>>, List<Triple<Int, Int, Int>>>): String {
        val stackMap = input.first
        val commands = input.second

        commands.forEach { trip ->
            val tempStack = ArrayDeque<Char>()
            for (i in 0 until trip.first) {
                val curEl = stackMap[trip.second - 1]?.pop()
                if (curEl != null) {
                    tempStack.push(curEl)
                }
            }
            tempStack.forEach { el ->
                stackMap[trip.third - 1]?.push(el)
            }
        }
        return stackMap.map { it.value.pop() }.joinToString("")
    }

    fun preprocess(input: List<String>): Pair<Map<Int, ArrayDeque<Char>>, List<Triple<Int, Int, Int>>> {
        val stackSize = input.indexOfFirst { it.startsWith(" 1") }
        val bucketCount = (input[stackSize].length + 2) / 4
        val stackMap = (0 until bucketCount).associateWith { ArrayDeque<Char>() }
        ((stackSize - 1) downTo 0).forEach { stackPos ->
            (0 until bucketCount).forEach { bucketPos ->
                val curLine = input[stackPos]
                val curPos = (bucketPos * 4) + 1
                if (curPos <= curLine.length && curLine[curPos] != ' ') {
                    stackMap[bucketPos]?.push(curLine[curPos])
                }
            }
        }

        val commands = mutableListOf<Triple<Int, Int, Int>>()
        (stackSize + 2 until input.size).forEach {
            val split = input[it].split(" ")
            commands.add(
                Triple(
                    split[1].toInt(), split[3].toInt(), split[5].toInt()
                )
            )
        }

        return Pair(stackMap, commands)
    }

    // test if implementation meets criteria from the description, like:
    check(part1(preprocess(readInput(5, true))) == "CMZ")
    check(part2(preprocess(readInput(5, true))) == "MCD")

    println(part1(preprocess(readInput(5))))
    println(part2(preprocess(readInput(5))))
}