import domain.Creature
import domain.Location
import domain.Race

fun main() {
    val murlocRace = Race("MURLOC", mutableMapOf(), mutableListOf())
    val location = Location("Mean Streets of Gadgetzan")
    val murloc = Creature("Finja, the Flying Star", location)
    val murloc2 = Creature("Sir Finley", location)
    murlocRace.members["MRGL"] = murloc
    murlocRace.members["MRGK"] = murloc2
    murlocRace.questions.add("MRRRGGK?")
    murlocRace.solveQuestions()
}