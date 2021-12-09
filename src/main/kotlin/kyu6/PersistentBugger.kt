package kyu6

object PersistentBugger {
    fun persistence(num: Int): Int =
        generateSequence(num) { it.toString().map { d -> d.digitToInt() }.reduce { acc: Int, i: Int -> acc * i } }
            .takeWhile { it > 9 }
            .count()
}