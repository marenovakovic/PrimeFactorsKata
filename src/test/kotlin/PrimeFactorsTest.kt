import kotlin.test.Test
import kotlin.test.assertEquals

class PrimeFactorsTest {

    @Test
    fun `factors recursive`() {
        assertEquals(emptyList(), primeFactorsRecursive(1))
        assertEquals(listOf(2), primeFactorsRecursive(2))
        assertEquals(listOf(3), primeFactorsRecursive(3))
        assertEquals(listOf(2, 2), primeFactorsRecursive(4))
        assertEquals(listOf(5), primeFactorsRecursive(5))
        assertEquals(listOf(2, 3), primeFactorsRecursive(6))
        assertEquals(listOf(7), primeFactorsRecursive(7))
        assertEquals(listOf(2, 2, 2), primeFactorsRecursive(8))
        assertEquals(listOf(3, 3), primeFactorsRecursive(9))
    }

    @Test
    fun `factors loop`() {
        assertEquals(emptyList(), primeFactorsLoop(1))
        assertEquals(listOf(2), primeFactorsLoop(2))
        assertEquals(listOf(3), primeFactorsLoop(3))
        assertEquals(listOf(2, 2), primeFactorsLoop(4))
        assertEquals(listOf(5), primeFactorsLoop(5))
        assertEquals(listOf(2, 3), primeFactorsLoop(6))
        assertEquals(listOf(7), primeFactorsLoop(7))
        assertEquals(listOf(2, 2, 2), primeFactorsLoop(8))
        assertEquals(listOf(3, 3), primeFactorsLoop(9))
    }
}

private fun primeFactorsRecursive(n: Int): List<Int> =
    primeFactorsRecursive(n, 2)

private fun primeFactorsRecursive(n: Int, divisor: Int): List<Int> =
    when {
        n % divisor == 0 -> listOf(divisor) + primeFactorsRecursive(n / divisor, divisor)
        n > divisor -> primeFactorsRecursive(n, divisor + 1)
        n > 1 -> listOf(n)
        else -> emptyList()
    }

private fun primeFactorsLoop(n: Int): List<Int> {
    val factors = mutableListOf<Int>()
    var number = n
    var divisor = 2
    while (number > 1) {
        while (number % divisor == 0) {
            factors += divisor
            number /= divisor
        }
        divisor++
    }
    return factors
}