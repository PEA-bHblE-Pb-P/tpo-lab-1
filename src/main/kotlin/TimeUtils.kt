import java.time.Instant

object TimeUtils {
    private var mockedNow: Instant = Instant.now()

    fun now(): Instant = mockedNow

    fun withMockedNow(now: Instant = Instant.now(), func: () -> Unit) {
        val prevNow = mockedNow
        mockedNow = now
        func()
        mockedNow = prevNow
    }

    fun skip(seconds: Long) {
        mockedNow = mockedNow.plusSeconds(seconds)
    }
}
