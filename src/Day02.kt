fun main() {
    fun part1(input: List<String>): Int {
        val scoreMap = mapOf("X" to 1, "Y" to 2, "Z" to 3)
        val winMap = mapOf("X" to "C", "Y" to "A", "Z" to "B")
        val drawMap = mapOf("X" to "A", "Y" to "B", "Z" to "C")

        var score = 0
        input.forEach {
            val parts = it.split(" ")
            val enemyChoice = parts[0]
            val myChoice = parts[1]

            score += scoreMap[myChoice]!!
            score += if (winMap[myChoice] == enemyChoice) 6 else 0
            score += if (drawMap[myChoice] == enemyChoice) 3 else 0
        }
        return score
    }

    fun part2(input: List<String>): Int {
        val resultScoreMap = mapOf("X" to 0, "Y" to 3, "Z" to 6)
        val winMap = mapOf("A" to 2, "B" to 3, "C" to 1)
        val drawMap = mapOf("A" to 1, "B" to 2, "C" to 3)
        val loseMap = mapOf("A" to 3, "B" to 1, "C" to 2)

        var score = 0
        input.forEach {
            val parts = it.split(" ")
            val enemyChoice = parts[0]
            val result = parts[1]

            score += resultScoreMap[result]!!
            score += when (result) {
                "X" -> loseMap[enemyChoice]!!
                "Y" -> drawMap[enemyChoice]!!
                "Z" -> winMap[enemyChoice]!!
                else -> 0
            }
        }
        return score
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput(2, true)
    check(part1(testInput) == 15)
    print(part2(testInput))
    check(part2(testInput) == 12)

    val input = readInput(2)
    println(part1(input))
    println(part2(input))
}