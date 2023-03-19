import domain.Human
import domain.HyperBrainCreature
import domain.Location
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DomainTests {
    @Test
    fun `simple`() {
        val s = Location("SPB")
        val t = Location("TMS")
        val i = HyperBrainCreature("Ivan", s)
        val v = HyperBrainCreature("Vsevolod", s)
        val m = Human("Max", s)
        val r = Human("Roman", s)

        // TODO замокай текущее время, чтобы кулдаун после действий прошёл
//         v.hitAndRun(r)
        m.moveTo(t)
//        v.hitAndRun(m)
        v.argue(arrayOf(i).toList())
    }
}