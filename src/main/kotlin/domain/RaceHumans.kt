package domain

class RaceHumans(name: String, override val members: Map<String, Human>) :
    Race(name, members)