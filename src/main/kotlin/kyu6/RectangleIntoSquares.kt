package kyu6

object RectangleIntoSquares {
    fun sqInRect(lng: Int, wdth: Int): List<Int>? {
        if (lng == wdth) {
            return null
        }
        return sqInRectRec(lng, wdth, ArrayList())
    }

    private tailrec fun sqInRectRec(first: Int, second: Int, list: MutableList<Int>): List<Int> {
        val bigger = kotlin.math.max(first, second)
        val smaller = kotlin.math.min(first, second)
        if (smaller <= 0) {
            return list
        }
        val next = bigger - smaller
        return sqInRectRec(next, smaller, addAndReturn(list, smaller))
    }

    private fun <T, E> addAndReturn(mc: T, e: E): T where T : MutableCollection<E> {
        mc.add(e)
        return mc
    }
}