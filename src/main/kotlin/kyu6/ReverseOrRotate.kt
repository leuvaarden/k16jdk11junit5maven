package kyu6

object ReverseOrRotate {
    fun revRot(nums: String, sz: Int): String =
        if (nums.isEmpty() || sz > nums.length)
            ""
        else
            IntRange(0, nums.length / sz - (if (nums.length % sz > 0) 0 else 1))
                .map { nums.substring(it * sz, kotlin.math.min(nums.length, (it + 1) * sz)) }
                .joinToString(separator = "") { if (it.length < sz) "" else magic(it) }


    private fun magic(nums: String): String =
        if (nums.map { it.digitToInt() }.sumOf { it * it * it } % 2 == 0)
            nums.reversed()
        else
            nums.substring(1) + nums.first()

}