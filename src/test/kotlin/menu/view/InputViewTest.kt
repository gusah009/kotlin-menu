package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.domain.Coach
import menu.domain.Coaches
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.mockito.MockedStatic
import org.mockito.Mockito.*
import java.util.stream.Stream


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InputViewTest {

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class InputCoach {
        private var mockedSettings: MockedStatic<Console>? = null

        @BeforeAll
        fun init() {
            mockedSettings = mockStatic(Console::class.java)
        }

        @AfterAll
        fun close() {
            mockedSettings!!.close()
        }

        @ParameterizedTest
        @MethodSource
        fun should_createSuccessfully_when_inputCoaches(inputString: String, expected: Coaches) {
            mockedSettings?.`when`<String> { Console.readLine() }?.thenReturn(inputString)
            val inputView = InputView()

            val result = inputView.inputCoaches()

            assertThat(result.containsAll(expected)).isTrue()
        }

        fun should_createSuccessfully_when_inputCoaches(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("hyo,mo", Coaches(listOf(Coach("hyo"), Coach("mo")))),
                Arguments.of("memo,hyo,mo", Coaches(listOf(Coach("memo"), Coach("hyo"), Coach("mo")))),
                Arguments.of(
                    "memo,hyo,mo,hoho",
                    Coaches(listOf(Coach("memo"), Coach("hyo"), Coach("mo"), Coach("hoho")))
                )
            )
        }

        @ParameterizedTest
        @MethodSource
        fun should_throwException_when_inputCoachNamesOutOfRange(inputString: String) {
            mockedSettings?.`when`<String> { Console.readLine() }?.thenReturn(inputString)
            val inputView = InputView()

            assertThatThrownBy { inputView.inputCoaches() }
                .isInstanceOf(IllegalArgumentException::class.java)
        }

        fun should_throwException_when_inputCoachNamesOutOfRange(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("m"),
                Arguments.of("hyo,m"),
                Arguments.of("memos,hyo,mo")
            )
        }

        @ParameterizedTest
        @MethodSource
        fun should_throwException_when_inputCoachesCountOutOfSize(inputString: String) {
            mockedSettings?.`when`<String> { Console.readLine() }?.thenReturn(inputString)
            val inputView = InputView()

            assertThatThrownBy { inputView.inputCoaches() }
                .isInstanceOf(IllegalArgumentException::class.java)
        }

        fun should_throwException_when_inputCoachesCountOutOfSize(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("mo"),
                Arguments.of(""),
                Arguments.of("memos,hyo,mo,mi,moo,ma")
            )
        }
    }
}