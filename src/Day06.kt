fun main() {
    fun partOneAndTwo(input: String, range: Int): Int {
        (0..input.length - range).forEach { i ->
            if (input.subSequence(i, i + range).toSet().size == range) {
                return i + range
            }
        }
        return 0
    }

    // test if implementation meets criteria from the description, like:
    check(partOneAndTwo(readInput(6, true)[0], 4) == 7)
    check(partOneAndTwo(readInput(6, true)[0], 14) == 19)

    println(partOneAndTwo(readInput(6)[0], 4))
    println(partOneAndTwo(readInput(6)[0], 14))
}