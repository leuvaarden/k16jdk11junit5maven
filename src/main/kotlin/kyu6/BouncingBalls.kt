package kyu6

object BouncingBalls {
    fun bouncingBall(h: Double, bounce: Double, window: Double): Int =
        if (h > 0 && bounce < 1 && bounce > 0 && window < h)
            1 + 2 * bouncingBallRecursive(h * bounce, bounce, window, 0)
        else
            -1


    private tailrec fun bouncingBallRecursive(h: Double, bounce: Double, window: Double, times: Int): Int =
        if (h <= window)
            times
        else
            bouncingBallRecursive(h * bounce, bounce, window, times + 1)
}