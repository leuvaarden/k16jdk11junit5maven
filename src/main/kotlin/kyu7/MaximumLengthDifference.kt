package kyu7

object MaximumLengthDifference {
    fun mxdiflg(a1: Array<String>, a2: Array<String>): Int {
        if (a1.isEmpty() || a2.isEmpty()) {
            return -1
        }
        val firstMax = a1.maxOf { it.length }
        val secondMax = a2.maxOf { it.length }
        val firstMin = a1.minOf { it.length }
        val secondMin = a2.minOf { it.length }
        if (firstMax >= secondMax && firstMin <= secondMin || secondMax >= firstMax && secondMin <= firstMin) {
            return kotlin.math.max(firstMax - secondMin, secondMax - firstMin)
        }
        return kotlin.math.max(firstMax, secondMax) - kotlin.math.min(firstMin, secondMin)
    }
}