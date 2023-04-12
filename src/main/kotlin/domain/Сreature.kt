package domain

abstract class Creature(val name: String, var location: Location) {
    protected val state = State()

    fun moveTo(location: Location) {
        this.state.update(State.Type.MOVING)
        this.location = location
        println("${this.name} перемещается в ${location.name}")
    }

    fun getStateType(): State.Type {
        return state.type
    }
}