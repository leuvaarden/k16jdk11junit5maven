package kyu4

import kotlin.time.Duration.Companion.seconds

object HumanReadableDurationFormat {
    fun formatDuration(seconds: Int): String =
        seconds.seconds
            .toComponents { d, h, m, s, _ -> toComponents(d / 365, d % 365, h.toLong(), m.toLong(), s.toLong()) }
            .filterNotNull()
            .reduceRightIndexedOrNull { index, s, acc -> "$acc${if (index == 0) " and" else ","} $s" }
            ?: "now"

    private fun toComponents(y: Long, d: Long, h: Long, m: Long, s: Long): Array<String?> =
        arrayOf(msg(s, "second"), msg(m, "minute"), msg(h, "hour"), msg(d, "day"), msg(y, "year"))

    private fun msg(n: Long, word: String) = if (n > 0) "$n $word${if (n > 1) "s" else ""}" else null
}