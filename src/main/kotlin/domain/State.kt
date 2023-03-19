package domain

import java.time.Instant

class State {
    private var type: Type = Type.CHILL
    private var lastStateUpdate: Long = 0

    enum class Type(val cooldown: Long) {
        CHILL(0),
        ARGUMENT(40),
        PLAYING(20),
        MOVING(30)
    }

    fun update(type: Type) {
        require(lastStateUpdate + type.cooldown < Instant.now().epochSecond)
        this.type = type
        lastStateUpdate = Instant.now().epochSecond
    }
}