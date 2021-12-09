import java.nio.charset.StandardCharsets
import java.util.*
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

object PropertyEncryptor {
    private val cipher = Cipher.getInstance("AES/GCM/NoPadding")
    private val base64Encoder = Base64.getEncoder()

    fun encrypt(lines: Collection<String>, toEncrypt: Collection<String>, keyBytes: ByteArray): Collection<String> {
        val properties = parseProperties(lines)
        val filtered = if (toEncrypt.isEmpty()) properties else properties.filter { toEncrypt.contains(it.key) }
        val key = readKey(keyBytes)
        val encrypted = encrypt(filtered, key)
        return mergeProperties(lines, encrypted)
    }

    private fun parseProperties(lines: Collection<String>): Map<String, String> {
        return lines.filter { it.contains('=') }
            .map { it.split('=') }
            .associate { Pair(it[0], it[1]) }
    }

    private fun readKey(keyBytes: ByteArray): SecretKey {
        return SecretKeySpec(keyBytes, "AES")
    }

    private fun encrypt(properties: Map<String, String>, key: SecretKey): Map<String, String> {
        cipher.init(Cipher.ENCRYPT_MODE, key)
        return properties.mapValues { encryptValue(it.value) }
    }

    private fun encryptValue(value: String): String {
        val bytes = value.toByteArray(StandardCharsets.UTF_8)
        val encryptedBytes = cipher.doFinal(bytes)
        val encrypted = base64Encoder.encodeToString(encryptedBytes)
        return "ENC@$encrypted"
    }

    private fun mergeProperties(lines: Collection<String>, properties: Map<String, String>): Collection<String> {
        return lines.map { mapLine(it, properties) }
    }

    private fun mapLine(line: String, properties: Map<String, String>): String {
        if (!line.contains('=')) {
            return line
        }
        val parts = line.split('=')
        if (!properties.containsKey(parts[0])) {
            return line
        }
        return parts[0] + '=' + properties[parts[0]]
    }
}