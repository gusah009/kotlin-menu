package menu.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CoachTest {

    @Test
    fun should_returnValidToString() {
        val expected = "[ 제임스 | 된장찌개 | 비빔밥 | 가츠동 | 토마토 달걀볶음 | 파인애플 볶음밥 ]"
        val coach = Coach(CoachName("제임스"), FoodInedible(listOf()))
        coach.recommend("된장찌개")
        coach.recommend("비빔밥")
        coach.recommend("가츠동")
        coach.recommend("토마토 달걀볶음")
        coach.recommend("파인애플 볶음밥")

        Assertions.assertThat(coach).hasToString(expected)
    }
}