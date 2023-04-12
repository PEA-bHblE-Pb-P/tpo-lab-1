import java.time.Instant

object TimeUtils {
    private var mockedNow: Instant? = null

    fun now(): Instant = mockedNow ?: Instant.now()

    private fun resetNow() {
        mockedNow = null
    }

    fun withMockedNow(now: Instant = Instant.now(), func: () -> Unit) {
        mockedNow = now
        func()
        resetNow()
    }

    fun skip(seconds: Long) {
        check(mockedNow != null)
        mockedNow = mockedNow!!.plusSeconds(seconds)
    }
}