package menu.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class FoodInedibleTest {

    @ParameterizedTest
    @MethodSource
    fun should_successfully_when_validFoodCount(foods: List<String>) {
        val foodInedible = FoodInedible(foods)

        assertThat(foodInedible.foods).containsAll(foods)
    }

    @ParameterizedTest
    @MethodSource
    fun should_throwException_when_inValidFoodCount(foods: List<String>) {
        assertThrows<IllegalArgumentException> { FoodInedible(foods) }
    }

    companion object {
        @JvmStatic
        fun should_successfully_when_validFoodCount() = Stream.of(
            Arguments.of(listOf<String>()),
            Arguments.of(listOf("김밥")),
            Arguments.of(listOf("김밥", "김치찌개")),
        )

        @JvmStatic
        fun should_throwException_when_inValidFoodCount() = Stream.of(
            Arguments.of(listOf("김밥", "김치찌개", "쌈밥")),
            Arguments.of(listOf("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기")),
            Arguments.of(listOf("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
        )
    }
}