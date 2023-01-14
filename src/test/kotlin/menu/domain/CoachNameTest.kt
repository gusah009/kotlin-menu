package menu.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CoachNameTest {

    @ParameterizedTest
    @ValueSource(strings = ["mo", "hyo", "limm", "한글", "정현모", "이효림림"])
    fun should_successfully_when_validName(name: String) {
        val coachName = CoachName(name)

        assertThat(coachName.name).isEqualTo(name)
    }

    @ParameterizedTest
    @ValueSource(strings = ["m", "효", "림", "정현모이효림", "abcdef", "abcdefghijklmn"])
    fun should_throwException_when_inValidName(name: String) {
        assertThrows<IllegalArgumentException> { CoachName(name) }
    }
}