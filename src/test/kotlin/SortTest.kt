import Sort.selectionSort
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class SortTest {
    @TestFactory
    fun `selection sort test`(): Collection<DynamicTest> {
        return listOf(
            arrayOf(arrayOf(), arrayOf(), arrayOf()),
            arrayOf(arrayOf(1), arrayOf(), arrayOf(1)),
            arrayOf(arrayOf(1, 1), arrayOf(1, 1), arrayOf(1, 1)),
            arrayOf(arrayOf(1, 1, 1), arrayOf(1, 1, 1, 1), arrayOf(1, 1, 1)),
            arrayOf(arrayOf(1, 2, 3, 4), arrayOf(1, 1, 2, 2, 3, 3), arrayOf(1, 2, 3, 4)),
            arrayOf(arrayOf(4, 3, 2, 1), arrayOf(1, 4, 2, 3, 3, 3), arrayOf(1, 2, 3, 4)),
            arrayOf(arrayOf(5, 42, 3, 0), arrayOf(0, 5, 3, 42, 5, 42), arrayOf(0, 3, 5, 42)),
        ).map {
            DynamicTest.dynamicTest("Sorting") {
                val logs = selectionSort(it[0])
                assertThat(logs.toTypedArray()).isEqualTo(it[1])
            }
        }
    }
}
