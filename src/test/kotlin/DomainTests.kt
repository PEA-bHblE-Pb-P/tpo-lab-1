import TimeUtils.skip
import domain.Human
import domain.HyperBrainCreature
import domain.Location
import org.junit.jupiter.api.Test

class DomainTests {
    @Test
    fun simple() {
        val s = Location("SPB")
        val t = Location("TMS")
        val i = HyperBrainCreature("Ivan", s)
        val v = HyperBrainCreature("Vsevolod", s)
        val m = Human("Max", s)
        val r = Human("Roman", s)

        v.hitAndRun(r)
        m.moveTo(t)
        skip(21L)
        v.hitAndRun(m)
        skip(41L)
        v.argue(listOf(i))
    }
}