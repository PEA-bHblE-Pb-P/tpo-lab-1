package domain

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

open class Creature(val name: String, var location: Location, val race: Race) {
    protected val state = State()
    protected val mutex = Mutex()

    suspend fun moveTo(location: Location) {
            println("$name перемещается в ${location.name}")
            state.update(State.Type.MOVING)
            this@Creature.location = location
            println("$name перемещается")
    }

    suspend fun solveQuestion() {
        mutex.withLock {
            state.update(State.Type.SOLVING_QUESTIONS)
            println("$name подумал")
        }
    }
}
