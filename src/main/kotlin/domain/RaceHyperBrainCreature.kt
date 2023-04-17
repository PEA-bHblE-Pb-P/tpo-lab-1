package domain

class RaceHyperBrainCreature(
    name: String, override val members: Map<String, HyperBrainCreature>,
    questions: ArrayList<String>
) :
    Race(name, members, questions)