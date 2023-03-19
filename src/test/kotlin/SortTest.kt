import org.junit.jupiter.api.Assertions.*

import Sort.selectionSort
import org.junit.jupiter.api.Test

class SelectionSortTest {
    @Test
    fun `simple sort`() {
        val a = arrayOf(5, 42, 3, 0)
        val logs = selectionSort(a)
        assertArrayEquals(a, arrayOf(0, 3, 5, 42))
        assertArrayEquals(logs.toTypedArray(), arrayOf(0, 5, 3, 42, 5, 42))
    }
}