import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.data.Offset.offset
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.*
import java.util.stream.Stream
import kotlin.math.PI

class MathTest {
    @Test
    fun `simple pow`() {
        assertThat(Math.arctg(1.0, 0.001))
            .isCloseTo(PI/4, offset(0.001))
    }

    @ParameterizedTest
    @ArgumentsSource(TestInputProvider::class)
    fun parameterizedTest(x: Double, eps: Double, expected: Double) {
        assertThat(Math.arctg(x, eps))
            .isCloseTo(expected, offset(eps))
    }

    class TestInputProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<Arguments> =
            Stream.of(
                Arguments.of(-1.73205,   0.00001,   -1.047197),
                Arguments.of(-0.57735,   0.00001,   -0.523598),
                Arguments.of( 0.0,       0.00001,    0.0),
                Arguments.of( 0.57735,   0.00001,    0.523598),
                Arguments.of( 1.73205,   0.00001,    1.047197)
            )
    }
}