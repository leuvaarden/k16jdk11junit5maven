package kyu3

object ScreenLockingPatterns {
    fun countPatternsFrom(firstPoint: String, length: Int): Int =
        if (length < 1)
            0
        else
            generateSequence(listOf(listOf(firstPoint))) { l -> l.flatMap { generate(it) }.filter { it.isNotEmpty() } }
                .drop(length - 1)
                .first()
                .count()

    private fun generate(code: List<String>): List<List<String>> {
        val next = availableNext(code)
        return if (next.isEmpty()) emptyList() else next.map { code + it }
    }

    private fun availableNext(previous: List<String>): List<String> =
        AvailableFrom.valueOf(previous.last())
            .one
            .filter { !previous.contains(it) } +
                AvailableFrom.valueOf(previous.last())
                    .two
                    .filter { previous.contains(it.first) && !previous.contains(it.second) }
                    .map { it.second }


    private enum class AvailableFrom(val one: List<String>, val two: List<Pair<String, String>>) {
        A(listOf("B", "D", "E", "F", "H"), listOf(Pair("B", "C"), Pair("D", "G"), Pair("E", "I"))),
        B(listOf("A", "C", "D", "E", "F", "G", "I"), listOf(Pair("E", "H"))),
        C(listOf("B", "D", "E", "F", "H"), listOf(Pair("B", "A"), Pair("E", "G"), Pair("F", "I"))),
        D(listOf("A", "B", "C", "E", "G", "H", "I"), listOf(Pair("E", "F"))),
        E(listOf("A", "B", "C", "D", "F", "G", "H", "I"), emptyList()),
        F(listOf("A", "B", "C", "E", "G", "H", "I"), listOf(Pair("E", "D"))),
        G(listOf("B", "D", "E", "F", "H"), listOf(Pair("D", "A"), Pair("E", "C"), Pair("H", "I"))),
        H(listOf("A", "C", "D", "E", "F", "G", "I"), listOf(Pair("E", "B"))),
        I(listOf("B", "D", "E", "F", "H"), listOf(Pair("E", "A"), Pair("F", "C"), Pair("H", "G"))),
    }
}