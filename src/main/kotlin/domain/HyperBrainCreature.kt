package domain

import domain.Race.HYPER_BRAIN
import kotlinx.coroutines.runBlocking

class HyperBrainCreature(name: String, location: Location) : Creature(name, location, HYPER_BRAIN) {

    fun argue(opponents: List<HyperBrainCreature>) = runBlocking {
        require(opponents.all {
            it.location.name == location.name
        })
        opponents.forEach {
            it.state.update(State.Type.ARGUMENT)
        }
        state.update(State.Type.ARGUMENT)
    }

    fun hitAndRun(victim: Human) = runBlocking {
        victim.requireLocation(location)
        state.update(State.Type.PLAYING)
        println("$name ударил ${victim.name} и убежал")
    }

}
