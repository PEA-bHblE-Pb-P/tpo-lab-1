package domain

import domain.Race.HUMAN

class Human(name: String, location: Location) : Creature(name, location, HUMAN) {
    fun requireLocation(requiredLocation: Location) =
        require(location.name == requiredLocation.name)
}
