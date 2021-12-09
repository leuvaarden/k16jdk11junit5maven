package kyu5

object WeightForWeight {
    fun orderWeight(string: String): String =
        string.trim()
            .split(" ")
            .sortedWith(Comparator.comparing<String, Int> { s -> s.sumOf { it.digitToInt() } }.thenComparing { s -> s })
            .joinToString(" ")
}