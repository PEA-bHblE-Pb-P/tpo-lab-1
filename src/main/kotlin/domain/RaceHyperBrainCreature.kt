package domain

class RaceHyperBrainCreature(
    name: String, members: MutableList<HyperBrainCreature>,
    questions: ArrayList<String>
) :
    Race<HyperBrainCreature>(name, members, questions)