package domain

import TimeUtils.skip
import TimeUtils.withMockedNow
import domain.State.Type.CHILL
import domain.State.Type.PLAYING
import kotlinx.coroutines.*
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

class StateTest {
    @Test
    fun `isBusy should return false for initial state`() = withTest {
        val state = State()

        assertThat(state.isBusy()).isFalse
    }

    @Test
    fun `isBusy should return true when total cooldown equals now`() = withTest {
        val state = State()

        state.update(PLAYING)
        skip(PLAYING.cooldown)

        assertThat(state.isBusy()).isTrue
    }

    @Test
    fun `isBusy should return true when total cooldown is more than now`() = withTest {
        val state = State()

        state.update(PLAYING)
        skip(PLAYING.cooldown-1)

        assertThat(state.isBusy()).isTrue
    }

    @Test
    fun `isBusy should return true when total cooldown is less than now`() = withTest {
        val state = State()

        state.update(PLAYING)
        skip(PLAYING.cooldown+1)

        assertThat(state.isBusy()).isFalse
    }

    @TestFactory
    fun `isBusy with random state type`(): Collection<DynamicTest> {
        val stateType = State.Type.values().random()
        return listOf(
            dynamicTest("should return true before cooldown") {
                withTest {
                    val state = State()

                    state.update(stateType)
                    skip(stateType.cooldown - 42L)

                    assertThat(state.isBusy()).isTrue
                }
            },
            dynamicTest("should return false after cooldown") {
                withTest {
                    val state = State()

                    state.update(stateType)
                    skip(stateType.cooldown + 42L)

                    assertThat(state.isBusy()).isFalse
                }
            },
        )
    }

    @Test
    fun `update should not require cooldown for initial state`() = withTest {
        val state = State()

        state.update(CHILL)
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun `update should require cooldown`() = withTest {
        val state = State()

        assertThatThrownBy {
            runBlocking {
                    println("1)")
                    launch(newSingleThreadContext("1")) {
                        println("1)))")
                        state.update(CHILL)
                    }

                    println("2)")
                    launch(newSingleThreadContext("2")) {
                        println("2)))")
                        state.update(CHILL)
                    }
            }
        }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
    }

    private fun withTest(test: suspend () -> Unit) = withMockedNow {
        runBlocking {
            test()
        }
    }
}
