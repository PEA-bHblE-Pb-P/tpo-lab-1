package domain

class RaceHumans(name: String, members: MutableList<Human>, questions: ArrayList<String>) :
    Race<Human>(name, members, questions)