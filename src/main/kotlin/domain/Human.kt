package domain

class Human(name: String, location: Location) : Creature(name, location) {
    fun requireLocation(requiredLocation: Location) =
        require(location.name == requiredLocation.name)
}
