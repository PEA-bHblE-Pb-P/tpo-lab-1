package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CreatureTest {
    @Test
    fun `can set location`() {
        val creature: Creature =
            HyperBrainCreature("creature", Location("test-1"))

        creature.location = Location("test-2")

        assertThat(creature.location)
            .isEqualTo(Location("test-2"))
    }
}
