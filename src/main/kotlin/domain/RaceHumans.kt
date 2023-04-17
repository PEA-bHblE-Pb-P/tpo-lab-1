package domain

class RaceHumans(name: String, override val members: Map<String, Human>, questions: ArrayList<String>) :
    Race(name, members, questions)