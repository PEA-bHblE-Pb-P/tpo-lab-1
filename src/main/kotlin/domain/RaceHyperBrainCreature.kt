package domain

class RaceHyperBrainCreature(
    name: String, members: MutableMap<String, HyperBrainCreature>,
    questions: ArrayList<String>
) :
    Race<HyperBrainCreature>(name, members, questions)