import Sort.selectionSort
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SelectionSortTest {
    @Test
    fun `simple sort`() {
        val a = arrayOf(5, 42, 3, 0)
        val logs = selectionSort(a)
        assertThat(a).isEqualTo(arrayOf(0, 3, 5, 42))
        assertThat(logs).isEqualTo(listOf(0, 5, 3, 42, 5, 42))
    }
}