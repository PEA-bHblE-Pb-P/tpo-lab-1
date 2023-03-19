object Sort {
    fun <T : Comparable<T>> selectionSort(array: Array<T>) : List<T> {
        val logs = mutableListOf<T>()
        for (i in 0 until array.size - 1) {
            var minPos = i
            for (j in i + 1 until array.size) {
                if (array[j] < array[minPos]) {
                    minPos = j
                }
            }
            logs.add(array[minPos])
            logs.add(array[i])
            val saveValue = array[minPos]
            array[minPos] = array[i]
            array[i] = saveValue
        }
        return logs
    }
}