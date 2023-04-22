package domain

open class Race <T: Creature> (open val name: String, val members: MutableList<T>, val questions: MutableList<String>) {
    fun meeting(location: Location) {
        println("Раса ${this.name} собирается в одном месте")
        members.forEach {
            it.moveTo(location)
        }
    }

    fun solveQuestions() {
        println("Раса ${this.name} решает вопросы")
        questions.forEach { question ->
            println("Вопрос: $question")
            members.forEach {
                it.solveQuestions()
            }
        }
        questions.clear()
        println("Вопросы решены")
    }
}