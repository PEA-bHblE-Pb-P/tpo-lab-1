package domain

import domain.Race.HYPER_BRAIN

class HyperBrainCreature(name: String, location: Location) : Creature(name, location, HYPER_BRAIN) {

    fun argue(opponents: List<HyperBrainCreature>) {
        require(opponents.all {
            it.location.name == this.location.name
        })
        opponents.forEach {
            it.state.update(State.Type.ARGUMENT)
        }
        state.update(State.Type.ARGUMENT)
    }

    fun hitAndRun(victim: Human) {
        victim.requireLocation(this.location)
        this.state.update(State.Type.PLAYING)
        println("${this.name} ударил ${victim.name} и убежал")
    }

}
