import java.util.*

fun main() {
    fun part1(input: List<String>): Int {
        var maxVal: Int = Int.MIN_VALUE
        var cur = 0

        input.forEach {
            if (it == "") {
                maxVal = if (cur > maxVal) cur else maxVal
                cur = 0
            } else {
                cur += Integer.parseInt(it)
            }
        }
        return maxVal
    }

    fun part2(input: List<String>): Int {
        val calories = PriorityQueue<Int>()
        var cur = 0

        input.forEach {
            if (it == "") {
                calories.add(cur)
                cur = 0

                if (calories.size > 3) {
                    calories.poll()
                }
            } else {
                cur += Integer.parseInt(it)
            }
        }
        return calories.sumOf { it }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput(1, true)
    (testInput as MutableList<String>).add("")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput(1)
    (input as MutableList<String>).add("")
    println(part1(input))
    println(part2(input))
}
