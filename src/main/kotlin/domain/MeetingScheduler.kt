package domain

import java.time.Instant

class MeetingScheduler(private val creatures: List<Creature>) {
    fun scheduleMeetingByRace(race: Race, questions: List<String>, location: Location, time: Instant) =
        Meeting(race, creatures.filter { it.race == race }, questions, location, time )
}