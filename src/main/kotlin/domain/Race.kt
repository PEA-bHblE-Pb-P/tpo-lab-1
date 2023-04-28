package domain

open class Race <T: Creature> (open val name: String, open val members: MutableMap<String, T>, val questions: MutableList<String>) {
    fun meeting(location: Location) {
        println("Раса ${this.name} собирается в одном месте")
        members.forEach {
            it.value.moveTo(location)
        }
    }

    fun solveQuestions() {
        println("Раса ${this.name} решает вопросы")
        questions.forEach { question ->
            println("Question: $question")
            members.forEach {
                it.value.solveQuestions()
            }
        }
        questions.clear()
        println("Вопросы решены")
    }
}