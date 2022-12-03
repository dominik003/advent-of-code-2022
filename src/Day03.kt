fun main() {
    fun calcCharValue(char: Char): Int {
        if (char.isLowerCase()) {
            return (char.code - 97) + 1
        }
        return (char.code - 65) + 27
    }

    fun part1(input: List<String>): Int {
        var prioritySum = 0
        input.forEach {
            val compartments: List<String> = it.chunked(it.length / 2)
            val wrongItems = compartments[0].toCharArray().toSet() intersect compartments[1].toCharArray().toSet()
            wrongItems.forEach { c ->
                prioritySum += calcCharValue(c)
            }
        }
        return prioritySum
    }

    fun part2(input: List<String>): Int {
        var prioritySum = 0
        input.chunked(3).forEach {
            val groupBadge =
                it[0].toCharArray().toSet() intersect it[1].toCharArray().toSet() intersect it[2].toCharArray().toSet()
            prioritySum += calcCharValue(groupBadge.first())
        }

        return prioritySum
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput(3, true)
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput(3)
    println(part1(input))
    println(part2(input))
}