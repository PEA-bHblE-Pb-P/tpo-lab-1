package domain

class RaceHumans(name: String, members: MutableMap<String, Human>, questions: ArrayList<String>) :
    Race<Human>(name, members, questions)