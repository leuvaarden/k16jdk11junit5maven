package kyu7

import kotlin.math.ceil
import kotlin.math.log

object DeodorantEvaporator {
    fun evaporator(content: Double, evapPerDay: Double, threshold: Double): Int =
        ceil(log(threshold / 100, (1 - evapPerDay / 100))).toInt()
}