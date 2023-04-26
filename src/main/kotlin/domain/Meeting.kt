//package domain
//
//import TimeUtils.now
//import TimeUtils.skip
//import domain.State.Type.MOVING
//import domain.State.Type.SOLVING_QUESTIONS
//import java.time.Instant
//
//class Meeting(
//    private val race: Race,
//    private val creatures: List<Creature>,
//    private val questions: List<String>,
//    private val location: Location,
//    private val time: Instant
//): () -> Unit {
//    override fun invoke() {
//        if (now() == time) {
//            meet(location)
//            solveQuestions()
//        }
//    }
//
//    private fun meet(location: Location) {
//        println("Раса $race собирается в одном месте")
//        creatures.forEach {
//            it.moveTo(location)
//        }
//        skip(MOVING.cooldown+1)
//        println("Раса $race собралась в месте (${location.name})")
//    }
//
//    private fun solveQuestions() {
//        println("Раса $race решает вопросы")
//        questions.forEach { question ->
//            println("Вопрос: $question")
//            creatures.forEach {
//                it.solveQuestion()
//            }
//            skip(SOLVING_QUESTIONS.cooldown+1)
//        }
//        println("Вопросы решены")
//    }
//}