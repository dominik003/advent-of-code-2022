fun main() {
    fun part1(input: List<String>): Int {
        var counter = 0
        input.forEach {
            val ranges = it.split(",")
            val leftSide = ranges[0].split("-").map { cur -> Integer.parseInt(cur) }
            val rightSide = ranges[1].split("-").map { cur -> Integer.parseInt(cur) }

            counter += if (leftSide[0] < rightSide[0]) {
                if (leftSide[1] >= rightSide[1]) 1 else 0
            } else if (rightSide[0] < leftSide[0]) {
                if (rightSide[1] >= leftSide[1]) 1 else 0
            } else {
                1
            }
        }
        return counter
    }

    fun part2(input: List<String>): Int {
        var counter = 0
        input.forEach {
            val ranges = it.split(",")
            val leftSide = ranges[0].split("-").map { cur -> Integer.parseInt(cur) }
            val rightSide = ranges[1].split("-").map { cur -> Integer.parseInt(cur) }

            val overlaps = (leftSide[0]..leftSide[1]).toSet() intersect (rightSide[0]..rightSide[1]).toSet()
            counter += if (overlaps.isNotEmpty()) 1 else 0
        }

        return counter
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput(4, true)
    check(part1(testInput) == 2)
    println(part2(testInput))
    check(part2(testInput) == 4)

    val input = readInput(4)
    println(part1(input))
    println(part2(input))
}