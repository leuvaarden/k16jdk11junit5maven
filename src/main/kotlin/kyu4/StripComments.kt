package kyu4

object StripComments {
    fun solution(input: String, markers: CharArray): String =
        input.lines().joinToString("\n") { it.substring(0, endIndex(markers, it)).trimEnd() }

    private fun endIndex(markers: CharArray, line: String) =
        markers.map { line.indexOf(it) }.filter { it != -1 }.minOrNull() ?: line.length
}