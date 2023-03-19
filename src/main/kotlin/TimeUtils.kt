import java.time.Instant

object TimeUtils {
    private var mockedNow: Instant = Instant.now()

    fun now() = mockedNow

    fun withMockedNow(now: Instant, func: () -> Unit) {
        mockedNow = now
        func()
    }

    fun skip(seconds: Long) {
        mockedNow = mockedNow.plusSeconds(seconds)
    }
}