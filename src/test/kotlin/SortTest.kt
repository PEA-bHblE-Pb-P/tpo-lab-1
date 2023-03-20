import Sort.selectionSort
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import java.util.*

class SelectionSortTest {

    @TestFactory
    fun tests(): Collection<DynamicTest?>? {
        return listOf(
            arrayOf(arrayOf(4, 3, 2, 1), arrayOf(1, 4, 2, 3, 3, 3), arrayOf(1, 2, 3, 4)),
            arrayOf(arrayOf(5, 42, 3, 0), arrayOf(0, 5, 3, 42, 5, 42), arrayOf(0, 3, 5, 42)),
        ).map {
            DynamicTest.dynamicTest("Invalid game") {
                val logs = selectionSort(it[0])
                assertThat(logs.toTypedArray()).isEqualTo(it[1])
            }
        }
    }

}