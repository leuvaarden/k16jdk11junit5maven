import kyu3.Physics.guess
import kyu3.ScreenLockingPatterns.countPatternsFrom
import kyu4.HumanReadableDurationFormat.formatDuration
import kyu4.StripComments.solution
import kyu4.SumByFactors.sumOfDivided
import kyu5.Int32ToIp4.longToIP
import kyu5.ProductOfConsecutiveFibNumbers.productFib
import kyu5.WeightForWeight.orderWeight
import kyu6.BouncingBalls.bouncingBall
import kyu6.DecodeTheMorseCode.decodeMorse
import kyu6.EncryptThis.encryptThis
import kyu6.FindTheParityOutlier.find
import kyu6.Meeting.meeting
import kyu6.PersistentBugger.persistence
import kyu6.RectangleIntoSquares.sqInRect
import kyu6.ReverseOrRotate.revRot
import kyu7.DeodorantEvaporator.evaporator
import kyu7.MaximumLengthDifference.mxdiflg
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Tests {
    @Test
    fun deodorantEvaporatorTest() {
        assertEquals(22, evaporator(10.0, 10.0, 10.0))
        assertEquals(29, evaporator(10.0, 10.0, 5.0))
        assertEquals(59, evaporator(100.0, 5.0, 5.0))
    }

    @Test
    fun maximumLengthDifferenceTest() {
        assertEquals(
            13,
            mxdiflg(
                arrayOf(
                    "hoqq",
                    "bbllkw",
                    "oox",
                    "ejjuyyy",
                    "plmiis",
                    "xxxzgpsssa",
                    "xxwwkktt",
                    "znnnnfqknaz",
                    "qqquuhii",
                    "dvvvwz"
                ),
                arrayOf("cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww")
            )
        )
        assertEquals(
            10,
            mxdiflg(
                arrayOf("ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"),
                arrayOf("bbbaaayddqbbrrrv")
            )
        )
    }

    @Test
    fun rectangleIntoSquaresTest() {
        assertEquals(listOf(3, 2, 1, 1), sqInRect(5, 3))
        assertEquals(null, sqInRect(5, 5))
        assertEquals(listOf(14, 6, 6, 2, 2, 2), sqInRect(20, 14))
    }

    @Test
    fun reverseOrRotateTest() {
        assertEquals("330479108928157", revRot("733049910872815764", 5))
        assertEquals("1994033775182780067155464327690480265895", revRot("73304991087281576455176044327690580265896", 8))
        assertEquals(
            "1994033775182780067155464327690480265895",
            revRot("73304991087281576455176044327690580265896896028", 8)
        )
    }

    @Test
    fun meetingTest() {
        assertEquals(
            "(ARNO, ANN)(BELL, JOHN)(CORNWELL, ALEX)(DORNY, ABBA)(KERN, LEWIS)(KORN, ALEX)(META, GRACE)(SCHWARZ, VICTORIA)(STAN, MADISON)(STAN, MEGAN)(WAHL, ALEXIS)",
            meeting("Alexis:Wahl;John:Bell;Victoria:Schwarz;Abba:Dorny;Grace:Meta;Ann:Arno;Madison:STAN;Alex:Cornwell;Lewis:Kern;Megan:Stan;Alex:Korn")
        )
        assertEquals(
            "(BELL, MEGAN)(CORNWELL, AMBER)(DORNY, JAMES)(DORRIES, PAUL)(GATES, JOHN)(KERN, ANN)(KORN, ANNA)(META, ALEX)(RUSSEL, ELIZABETH)(STEVE, LEWIS)(WAHL, MICHAEL)",
            meeting("John:Gates;Michael:Wahl;Megan:Bell;Paul:Dorries;James:Dorny;Lewis:Steve;Alex:Meta;Elizabeth:Russel;Anna:Korn;Ann:Kern;Amber:Cornwell")
        )
        assertEquals(
            "(ARNO, ALEX)(ARNO, HALEY)(BELL, SARAH)(CORNWELL, ALISSA)(DORNY, PAUL)(DORRIES, ANDREW)(KERN, ANN)(KERN, MADISON)",
            meeting("Alex:Arno;Alissa:Cornwell;Sarah:Bell;Andrew:Dorries;Ann:Kern;Haley:Arno;Paul:Dorny;Madison:Kern")
        )
    }

    @Test
    fun decodeTheMorseCodeTest() {
        assertEquals("HEY JUDE", decodeMorse(".... . -.--   .--- ..- -.. ."))
    }

    @Test
    fun bouncingBallsTest() {
        assertEquals(3, bouncingBall(3.0, 0.66, 1.5))
        assertEquals(15, bouncingBall(30.0, 0.66, 1.5))
    }

    @Test
    fun encryptThisTest() {
        assertEquals("65 119esi 111dl 111lw 108dvei 105n 97n 111ka", encryptThis("A wise old owl lived in an oak"))
        assertEquals(
            "84eh 109ero 104e 115wa 116eh 108sse 104e 115eokp",
            encryptThis("The more he saw the less he spoke")
        )
        assertEquals(
            "84eh 108sse 104e 115eokp 116eh 109ero 104e 104dare",
            encryptThis("The less he spoke the more he heard")
        )
        assertEquals(
            "87yh 99na 119e 110to 97ll 98e 108eki 116tah 119esi 111dl 98dri",
            encryptThis("Why can we not all be like that wise old bird")
        )
        assertEquals("84kanh 121uo 80roti 102ro 97ll 121ruo 104ple", encryptThis("Thank you Piotr for all your help"))
    }

    @Test
    fun findTheParityOutlierTest() {
        assertEquals(3, find(arrayOf(2, 6, 8, -10, 3)))
        assertEquals(206847684, find(arrayOf(206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781)))
        assertEquals(0, find(arrayOf(Integer.MAX_VALUE, 0, 1)))
    }

    @Test
    fun persistentBuggerTest() {
        assertEquals(3, persistence(39))
        assertEquals(0, persistence(4))
        assertEquals(2, persistence(25))
        assertEquals(4, persistence(999))
    }

    @Test
    fun weightForWeightTest() {
        assertEquals("2000 103 123 4444 99", orderWeight("103 123 4444 99 2000"))
        assertEquals(
            "11 11 2000 10003 22 123 1234000 44444444 9999",
            orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123")
        )
    }

    @Test
    fun productOfConsecutiveFibNumbersTest() {
        assertArrayEquals(longArrayOf(55, 89, 1), productFib(4895))
        assertArrayEquals(longArrayOf(89, 144, 0), productFib(5895))
    }

    @Test
    fun screenLockingPatternsTest() {
        assertEquals(0, countPatternsFrom("A", 10), "Should return 0 for path of length 10 with starting point A")
        assertEquals(0, countPatternsFrom("A", 0), "Should return 0 for path of length 0 with starting point A")
        assertEquals(0, countPatternsFrom("E", 14), "Should return 0 for path of length 14 with starting point E")
        assertEquals(1, countPatternsFrom("B", 1), "Should return 1 for path of length 1 with starting point B")
        assertEquals(5, countPatternsFrom("C", 2), "Should return 5 for path of length 2 with starting point C")
        assertEquals(8, countPatternsFrom("E", 2), "Should return 8 for path of length 2 with starting point E")
        assertEquals(256, countPatternsFrom("E", 4), "Should return 256 for path of length 4 with starting point E")
    }

    @Test
    fun humanReadableDurationFormatTest() {
        assertEquals("1 second", formatDuration(1))
        assertEquals("1 minute and 2 seconds", formatDuration(62))
        assertEquals("2 minutes", formatDuration(120))
        assertEquals("1 hour", formatDuration(3600))
        assertEquals("1 hour, 1 minute and 2 seconds", formatDuration(3662))
    }

    @Test
    fun physicsTest() {
        assertEquals(guess(), kotlin.random.Random.nextDouble())
    }

    @Test
    fun stripCommentsTest() {
        assertEquals(
            "apples, plums\npears\noranges",
            solution("apples, plums % and bananas\npears\noranges !applesauce", charArrayOf('%', '!'))
        )
        assertEquals("Q\nu\ne", solution("Q @b\nu\ne -e f g", charArrayOf('@', '-')))
    }

    @Test
    fun int32ToIp4Test() {
        assertEquals("128.114.17.104", longToIP(2154959208u))
        assertEquals("0.0.0.0", longToIP(0u))
        assertEquals("128.32.10.1", longToIP(2149583361u))
    }

    @Test
    fun sumByFactorsTest() {
        assertEquals("(2 12)(3 27)(5 15)", sumOfDivided(intArrayOf(12, 15)))
        assertEquals("(2 54)(3 135)(5 90)(7 21)", sumOfDivided(intArrayOf(15, 21, 24, 30, 45)))
        assertEquals(
            "(2 1032)(3 453)(5 310)(7 126)(11 110)(17 204)(29 116)(41 123)(59 118)(79 158)(107 107)",
            sumOfDivided(intArrayOf(107, 158, 204, 100, 118, 123, 126, 110, 116, 100))
        )
        assertEquals("", sumOfDivided(intArrayOf()))
        assertEquals(
            "(2 12620)(3 4530)(5 12620)(7 1260)(11 1100)(17 2040)(29 1160)(41 1230)(59 1180)(79 1580)(107 1070)",
            sumOfDivided(intArrayOf(1070, 1580, 2040, 1000, 1180, 1230, 1260, 1100, 1160, 1000))
        )
    }

    @Test
    fun foo() {
        listOf(Sample(1, 2), Sample(3, 4)).forEach { (a, b) -> println(a + b) }
    }

    private data class Sample(val a: Int, val b: Long)
}