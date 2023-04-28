package domain

open class Race(open val name: String, open val members: Map<String, Creature>, val questions: ArrayList<String>) {
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
        questions.clear()
        println("Вопросы решены")
    }
}