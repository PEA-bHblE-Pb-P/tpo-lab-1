package domain

import TimeUtils.mockNow
import TimeUtils.skip
import domain.State.Type.PLAYING
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

class StateTest {
    @BeforeEach
    fun before() = mockNow()

    @Test
    fun `isBusy should return false for initial state`() {
        val state = State()

        assertThat(state.isBusy()).isFalse
    }

    @Test
    fun `isBusy should return true when total cooldown equals now`() {
        val state = State()

        state.update(PLAYING)
        skip(PLAYING.cooldown)

        assertThat(state.isBusy()).isTrue
    }

    @Test
    fun `isBusy should return true when total cooldown is more than now`() {
        val state = State()

        state.update(PLAYING)
        skip(PLAYING.cooldown-1)

        assertThat(state.isBusy()).isTrue
    }

    @Test
    fun `isBusy should return true when total cooldown is less than now`() {
        val state = State()

        state.update(PLAYING)
        skip(PLAYING.cooldown+1)

        assertThat(state.isBusy()).isFalse
    }

    @TestFactory
    fun `isBusy with random state type`(): Collection<DynamicTest> {
        val stateType = State.Type.values().random()
        return listOf(
            DynamicTest.dynamicTest("should return true before cooldown") {
                val state = State()

                state.update(stateType)
                skip(stateType.cooldown-42L)

                assertThat(state.isBusy()).isTrue
            },
            DynamicTest.dynamicTest("should return false after cooldown") {
                val state = State()

                state.update(stateType)
                skip(stateType.cooldown+42L)

                assertThat(state.isBusy()).isFalse
            },
        )
    }


}