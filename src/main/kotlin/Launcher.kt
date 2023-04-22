import domain.Creature
import domain.Location
import domain.Race

fun main() {
    val location = Location("планета Вогсфера")
    val earth = Location("планета Земля")
    val vogonRace = Race(
        name = "ВОГОНЫ",
        members = mutableListOf(
            Creature("Простатник Джелц", location),
            Creature("Простатник Бырдц", location),
            Creature("Туп Непрроходим", location)
        ),
        questions = mutableListOf()
    )

    vogonRace.questions.add("Может уничтожим Землю?")
    vogonRace.questions.add("Как распространить бюрократию по Вселенной?")

    vogonRace.meeting(earth)
    vogonRace.solveQuestions()
}