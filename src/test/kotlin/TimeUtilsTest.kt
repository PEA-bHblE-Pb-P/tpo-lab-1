import TimeUtils.skip
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class TimeUtilsTest {
    @Test
    fun `skip should throw IllegalStateException if now is not mocked`() {
        assertThatThrownBy {
           skip(42L)
        }
            .isExactlyInstanceOf(IllegalStateException::class.java)
    }
}
