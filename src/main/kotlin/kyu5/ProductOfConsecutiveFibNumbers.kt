package kyu5

object ProductOfConsecutiveFibNumbers {
    fun productFib(prod: Long): LongArray =
        generateSequence(Pair(0L, 1L)) { Pair(it.second, it.first + it.second) }
            .dropWhile { it.first * it.second < prod }
            .map { arrayOf(it.first, it.second, if (it.first * it.second == prod) 1 else 0) }
            .first()
            .toLongArray()
}