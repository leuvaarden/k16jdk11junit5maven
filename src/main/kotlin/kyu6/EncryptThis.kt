package kyu6

object EncryptThis {
    fun encryptThis(text: String): String =
        text.trim()
            .split(' ')
            .joinToString(" ") {
                it.first().code.toString() +
                        (if (it.length < 3)
                            it.substring(1)
                        else
                            it.last() + it.substring(2, it.length - 1) + it[1])
            }
}