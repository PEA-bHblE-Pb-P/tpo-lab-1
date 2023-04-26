//import domain.MeetingScheduler
import domain.Creature
import domain.Location
import domain.Race.VOGON
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val location = Location("планета Вогсфера")
    val earth = Location("планета Земля")
    val creatures = listOf(
        Creature("Простатник Джелц", location, VOGON),
        Creature("Простатник Бырдц", location, VOGON),
        Creature("Туп Непрроходим", location, VOGON)
    )


    launch(Dispatchers.IO) {
        creatures[0].solveQuestion()
        println("sec")
        creatures[0].solveQuestion()

    }
    creatures[0].solveQuestion()
    println("main")
    creatures[0].solveQuestion()


    val questions = listOf(
        "Может уничтожим Землю?",
        "Как распространить бюрократию по Вселенной?"
    )
//    val meetingScheduler = MeetingScheduler(creatures)
//
//    val meeting = meetingScheduler.scheduleMeetingByRace(VOGON, questions, earth, now())
//
//    meeting()
}