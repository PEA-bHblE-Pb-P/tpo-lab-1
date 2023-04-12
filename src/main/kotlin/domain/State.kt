package domain

import TimeUtils.now

class State {
    private var _type: Type = Type.CHILL
    val type get() = _type
    private var lastStateUpdate: Long = 0

    enum class Type(val cooldown: Long) {
        CHILL(0),
        ARGUMENT(40),
        PLAYING(20),
        MOVING(30)
    }

    fun update(type: Type) {
        require(!isBusy())
        this._type = type
        lastStateUpdate = now().epochSecond
    }

    fun isBusy(): Boolean {
        return lastStateUpdate + type.cooldown >= now().epochSecond
    }
}