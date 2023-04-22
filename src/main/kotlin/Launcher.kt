import TimeUtils.now
import TimeUtils.withMockedNow
import domain.Creature
import domain.Location
import domain.MeetingScheduler
import domain.Race
import domain.Race.VOGON
import java.time.Instant

fun main() = withMockedNow(Instant.now()) {
    val location = Location("планета Вогсфера")
    val earth = Location("планета Земля")
    val creatures = listOf(
        Creature("Простатник Джелц", location, VOGON),
        Creature("Простатник Бырдц", location, VOGON),
        Creature("Туп Непрроходим", location, VOGON)
    )
    val questions = listOf(
        "Может уничтожим Землю?",
        "Как распространить бюрократию по Вселенной?"
    )
    val meetingScheduler = MeetingScheduler(creatures)

    val meeting = meetingScheduler.scheduleMeetingByRace(VOGON, questions, earth, now())

    meeting()
}