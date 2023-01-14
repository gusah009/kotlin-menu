package menu.domain

import menu.domain.Category.*
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CategoriesTest {

    @Test
    fun should_toString() {
        val categories = Categories(listOf(Korean, Korean, Japanese, Chinese, Asian))

        Assertions.assertThat(categories).hasToString("[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]")
    }
}