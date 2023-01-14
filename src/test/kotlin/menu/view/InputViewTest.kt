package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.domain.*
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestInstance
import org.mockito.MockedStatic
import org.mockito.Mockito.*


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
    }
}