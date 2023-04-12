import java.time.Instant

object TimeUtils {
    private var mockedNow: Instant? = null

    fun now() = mockedNow ?: Instant.now()

    fun mockNow() {
        mockedNow = Instant.now()
    }

    fun withMockedNow(now: Instant, func: () -> Unit) {
        mockedNow = now
        func()
    }

    fun skip(seconds: Long) {
        check(mockedNow != null)
        mockedNow = mockedNow!!.plusSeconds(seconds)
    }
}