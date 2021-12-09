package kyu6

object FindTheParityOutlier {
    fun find(integers: Array<Int>): Int =
        if (integers.take(3).count { it % 2 == 0 } > 1)
            integers.find { it % 2 != 0 }!!
        else
            integers.find { it % 2 == 0 }!!
}

