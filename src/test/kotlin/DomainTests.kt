//import TimeUtils.skip
//import TimeUtils.withMockedNow
//import domain.*
//import domain.State.Type.CHILL
//import org.assertj.core.api.Assertions.assertThat
//import org.assertj.core.api.Assertions.assertThatThrownBy
//import org.junit.jupiter.api.DynamicTest
//import org.junit.jupiter.api.TestFactory
//
//class DomainTests {
//    private fun setupObjects(): Triple<Map<String, Location>, RaceHyperBrainCreature, RaceHumans> {
//        val locs: Map<String, Location> = listOf(
//            "SPb", "Moscow", "Tomsk"
//        ).associateWith { Location(it) }
//        val hypers: Map<String, HyperBrainCreature> = listOf(
//            "Ivan" to "SPb", "Seva" to "SPb", "Max" to "SPb"
//        ).associate { it.first to HyperBrainCreature(it.first, Location(it.second)) }
//        val humans: Map<String, Human> = listOf(
//            "Roman" to "SPb", "Dima" to "SPb"
//        ).associate { it.first to Human(it.first, Location(it.second)) }
//        return Triple(
//            locs,
//            RaceHyperBrainCreature(
//                "HyperBrain",
//                hypers,
//                ArrayList(arrayOf("Вопрос жизни, вселенной и всего такого").toMutableList())
//            ),
//            RaceHumans("Люди", humans, ArrayList())
//        )
//    }
//
//    @TestFactory
//    fun plays(): Collection<DynamicTest> {
//        return listOf(
//            DynamicTest.dynamicTest("Game") {
//                withMockedNow {
//                    val (locs, _hypers, _humans) = setupObjects()
//                    val hypers = _hypers.members
//                    val humans = _humans.members
//                    hypers["Seva"]!!.hitAndRun(humans["Roman"]!!)
//                    hypers["Max"]!!.moveTo(locs["Tomsk"]!!)
//                    skip(21L)
//                    hypers["Seva"]!!.hitAndRun(humans["Dima"]!!)
//                    skip(41L)
//                    hypers["Seva"]!!.argue(listOf(hypers["Ivan"]!!))
//                }
//            },
//            DynamicTest.dynamicTest("Meeting") {
//                withMockedNow {
//                    val (locs, _hypers, _humans) = setupObjects()
//                    _hypers.meeting(locs["Moscow"]!!)
//                    skip(31)
//                    _hypers.solveQuestions()
//                }
//            },
//            DynamicTest.dynamicTest("Other race") {
//                withMockedNow {
//                    val (locs, _hypers, _humans) = setupObjects()
//                    val dwarfs = Race("Dwarfs", mapOf("HelloMan" to Creature("HelloMan", locs["SPb"]!!)), ArrayList())
//                    assertThat(dwarfs.name).isEqualTo("Dwarfs")
//                    assertThat(dwarfs.questions.size).isEqualTo(0)
//                    dwarfs.members["HelloMan"]!!.moveTo(locs["Moscow"]!!)
//                }
//            }
//        )
//    }
//
//    @TestFactory
//    fun invalidActions(): Collection<DynamicTest> {
//        return listOf(
//            DynamicTest.dynamicTest("Invalid game") {
//                val (locs, _hypers, _humans) = setupObjects()
//                val hypers = _hypers.members
//                val humans = _humans.members
//                humans["Roman"]?.moveTo(locs["Moscow"]!!)
//                assertThatThrownBy { hypers["Seva"]?.hitAndRun(humans["Roman"]!!) }
//                    .isExactlyInstanceOf(IllegalArgumentException::class.java)
//            },
//            DynamicTest.dynamicTest("Invalid argue") {
//                val (locs, _hypers, _humans) = setupObjects()
//                val hypers = _hypers.members
//                hypers["Ivan"]?.moveTo(locs["Moscow"]!!)
//                assertThatThrownBy { hypers["Seva"]?.argue(listOf(hypers["Ivan"]!!)) }
//                    .isExactlyInstanceOf(IllegalArgumentException::class.java)
//            },
//            DynamicTest.dynamicTest("Invalid argue with some peoples") {
//                val (locs, _hypers, _humans) = setupObjects()
//                val hypers = _hypers.members
//                hypers["Ivan"]?.moveTo(locs["Moscow"]!!)
//                assertThatThrownBy {
//                    hypers["Seva"]?.argue(
//                        listOf(
//                            hypers["Max"]!!,
//                            hypers["Ivan"]!!
//                        )
//                    )
//                }
//                    .isExactlyInstanceOf(IllegalArgumentException::class.java)
//
//                assertThat(hypers["Max"]?.getStateType()).isEqualTo(CHILL)
//            },
//        )
//    }
//}
