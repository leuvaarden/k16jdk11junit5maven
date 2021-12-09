import java.security.Key
import javax.crypto.KeyGenerator

object SecretKeyGenerator {
    private val keyGenerator = KeyGenerator.getInstance("AES")

    init {
        keyGenerator.init(256)
    }

    fun generate(): Key {
        return keyGenerator.generateKey()
    }
}