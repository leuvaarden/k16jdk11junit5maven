package kyu6

object Meeting {
    fun meeting(s: String): String =
        s.uppercase()
            .split(';')
            .map { it.split(':') }
            .sortedWith(Comparator.comparing<List<String>, String> { t -> t[1] }.thenComparing { t -> t[0] })
            .joinToString("") { "(${it[1]}, ${it[0]})" }
}