import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.data.Offset.offset
import org.junit.jupiter.api.Test
import kotlin.math.PI

class MathTest {
    @Test
    fun `simple pow`() {
        assertThat(Math.arctg(1.0, 0.001))
            .isCloseTo(PI/4, offset(0.001))
    }
}