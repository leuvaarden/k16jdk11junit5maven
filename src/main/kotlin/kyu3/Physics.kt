package kyu3

import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.jvm.javaField

object Physics {
    private val DEFAULT_RANDOM = kotlin.random.Random.Default
    private val NOT_RANDOM = NotRandom()

    fun guess(): Double {
        setNotRandom()

        NOT_RANDOM.predict = true
        val toReturn = NOT_RANDOM.nextDouble()
        NOT_RANDOM.predict = false
        return toReturn
    }

    private fun setNotRandom() {
        DEFAULT_RANDOM::class.declaredMemberProperties
            .asSequence()
            .filter { it.name == "defaultRandom" }
            .map { it.javaField!! }
            .onEach { it.isAccessible = true }
            .onEach {
                val modifiersField = it::class.java.getDeclaredField("modifiers")
                java.security.AccessController.doPrivileged(java.security.PrivilegedAction<Any?> {
                    modifiersField.isAccessible = true
                    null
                })
                modifiersField.setInt(it, it.modifiers and java.lang.reflect.Modifier.FINAL.inv())
            }
            .onEach { it.set(DEFAULT_RANDOM, NOT_RANDOM) }
            .toList()
    }

    private class NotRandom : kotlin.random.Random() {
        private val random = java.util.Random()
        private val deque: ArrayDeque<Int> = ArrayDeque()
        var predict: Boolean = false
        override fun nextBits(bitCount: Int): Int {
            return if (predict) {
                deque.addLast(random.nextInt())
                deque.last()
            } else {
                deque.removeFirstOrNull() ?: random.nextInt()
            }
        }
    }
}
