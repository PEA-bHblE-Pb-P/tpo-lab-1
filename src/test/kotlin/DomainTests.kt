import TimeUtils.skip
import domain.Human
import domain.HyperBrainCreature
import domain.Location
import domain.State.Type.CHILL
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class DomainTests {
    private fun setupObjects(): Triple<Map<String, Location>, Map<String, HyperBrainCreature>, Map<String, Human>> {
        val locs: Map<String, Location> = listOf(
            "SPb", "Moscow", "Tomsk"
        ).associateWith { Location(it) }
        val hypers: Map<String, HyperBrainCreature> = listOf(
            "Ivan" to "SPb", "Seva" to "SPb", "Max" to "SPb"
        ).associate { it.first to HyperBrainCreature(it.first, Location(it.second)) }
        val humans: Map<String, Human> = listOf(
            "Roman" to "SPb", "Dima" to "SPb"
        ).associate { it.first to Human(it.first, Location(it.second)) }
        return Triple(locs, hypers, humans)
    }

    @TestFactory
    fun plays(): Collection<DynamicTest> {
        return listOf(
            DynamicTest.dynamicTest("Invalid game") {
                val (locs, hypers, humans) = setupObjects()
                hypers["Seva"]!!.hitAndRun(humans["Roman"]!!)
                hypers["Max"]!!.moveTo(locs["Tomsk"]!!)
                skip(21L)
                hypers["Seva"]!!.hitAndRun(humans["Dima"]!!)
                skip(41L)
                hypers["Seva"]!!.argue(listOf(hypers["Ivan"]!!))
            },
        )
    }

    @TestFactory
    fun invalidActions(): Collection<DynamicTest> {
        return listOf(
            DynamicTest.dynamicTest("Invalid game") {
                val (locs, hypers, humans) = setupObjects()
                humans["Roman"]?.moveTo(locs["Moscow"]!!)
                assertThatThrownBy { hypers["Seva"]?.hitAndRun(humans["Roman"]!!) }
                    .isExactlyInstanceOf(IllegalArgumentException::class.java)
            },
            DynamicTest.dynamicTest("Invalid argue") {
                val (locs, hypers, humans) = setupObjects()
                hypers["Ivan"]?.moveTo(locs["Moscow"]!!)
                assertThatThrownBy { hypers["Seva"]?.argue(listOf(hypers["Ivan"]!!)) }
                    .isExactlyInstanceOf(IllegalArgumentException::class.java)
            },
            DynamicTest.dynamicTest("Invalid argue with some peoples") {
                val (locs, hypers, humans) = setupObjects()
                hypers["Ivan"]?.moveTo(locs["Moscow"]!!)
                assertThatThrownBy {
                    hypers["Seva"]?.argue(
                        listOf(
                            hypers["Max"]!!,
                            hypers["Ivan"]!!
                        )
                    )
                }
                    .isExactlyInstanceOf(IllegalArgumentException::class.java)

                assertThat(hypers["Max"]?.getStateType()).isEqualTo(CHILL)
            },
        )
    }
}