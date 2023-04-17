package domain

class RaceHyperBrainCreature(name: String, override val members: Map<String, HyperBrainCreature>) :
    Race(name, members) {
    fun meeting(location: Location) {
        println("Раса ${this.name} собирается в одном месте")
        members.forEach {
            it.value.moveTo(location)
        }
    }

    fun solveQuestions() {
        println("Раса ${this.name} решает вопросы")
        members.forEach {
            it.value.solveQuestions()
        }
    }
}