package domain

import TimeUtils.now
import kotlinx.coroutines.delay

class State {
    private var _type: Type = Type.CHILL
    val type get() = _type
    private var lastStateUpdate: Long = 0

    enum class Type(val cooldown: Long) {
        CHILL(cooldown = 0),
        ARGUMENT(cooldown = 40),
        PLAYING(cooldown = 20),
        MOVING(cooldown = 30),
        SOLVING_QUESTIONS(cooldown = 50)
    }

    suspend fun update(type: Type) {
        require(!isBusy())
        this._type = type
        lastStateUpdate = now().epochSecond
        delay(type.cooldown * 100)
    }

    fun isBusy(): Boolean {
        return lastStateUpdate + type.cooldown >= now().epochSecond
    }
}
