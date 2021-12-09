package kyu4

object SumByFactors {
    fun sumOfDivided(l: IntArray): String =
        l.flatMap { getPrimeFactors(it).map { factor -> Pair(factor, it) } }
            .groupBy { it.first }
            .map { Pair(it.key, it.value.sumOf { value -> value.second }) }
            .sortedBy { it.first }.joinToString("") { "(${it.first} ${it.second})" }

    private tailrec fun getPrimeFactors(number: Int, i: Int = 2, factors: MutableSet<Int> = HashSet()): Set<Int> =
        if (i > number) {
            factors
        } else if (number % i == 0) {
            getPrimeFactors(number / i, i, (factors + i) as MutableSet<Int>)
        } else {
            getPrimeFactors(number, i + 1, factors)
        }
}