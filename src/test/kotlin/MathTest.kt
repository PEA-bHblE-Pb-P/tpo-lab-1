import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.PI

class MathTest {
    @Test
    fun `simple pow`() {
        assertEquals(Math.arctg(1.0, 0.001), PI/4, 0.001);
    }
}