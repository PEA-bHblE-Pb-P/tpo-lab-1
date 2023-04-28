import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.PI

object Math {
    fun arctg(x: Double, eps: Double = 0.001): Double {
        var normalizedX = x
        var moreOne = false
        var sign = 1
        if (normalizedX < 0){
            normalizedX *= -1
            sign = -1
        }
        if (abs(normalizedX) > 1) {
            normalizedX = 1 / normalizedX
            moreOne = true
        }

        var result = 0.0
        var cur = eps
        var i = 0
        while (eps <= abs(cur)) {
            cur = (-1.0).pow(i) * normalizedX.pow(2 * i + 1) / (2 * i + 1)
            result += cur
            i += 1
        }

        return if (moreOne) {
            sign * (PI / 2 - result)
        } else {
            sign * result
        }
    }
}
