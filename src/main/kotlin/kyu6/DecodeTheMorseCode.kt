package kyu6

object DecodeTheMorseCode {
    val MorseCode: Map<String, String> = mapOf(
        Pair("....", "H"),
        Pair(".", "E"),
        Pair("-.--", "Y"),
        Pair(".---", "J"),
        Pair("..-", "U"),
        Pair("-..", "D"),
    )

    fun decodeMorse(code: String): String =
        code.trim()
            .split(Regex(" {3}"))
            .map { it.split(' ') }
            .joinToString(" ") { it.joinToString("") { s -> MorseCode[s] ?: "" } }
}