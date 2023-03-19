import kotlin.math.abs
import kotlin.math.pow

object Math {
    fun arctg(x: Double, eps: Double = 0.001): Double {
        var result = 0.0
        var cur = eps;
        var i = 0
        while (eps <= abs(cur)) {
            cur = (-1.0).pow(i) * x.pow(2 * i + 1) / (2 * i + 1)
            result += cur
            i += 1
        }
        return result
    }
}