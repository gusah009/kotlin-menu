package menu.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CoachesTest {

    @Test
    fun should_toString() {

        val expected = """[ 제임스 | 된장찌개 | 비빔밥 | 가츠동 | 토마토 달걀볶음 | 파인애플 볶음밥 ]
[ 토미 | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ]"""
        val coach = Coach(CoachName("제임스"), FoodInedible(listOf()))
        coach.recommend("된장찌개")
        coach.recommend("비빔밥")
        coach.recommend("가츠동")
        coach.recommend("토마토 달걀볶음")
        coach.recommend("파인애플 볶음밥")

        val coach2 = Coach(CoachName("토미"), FoodInedible(listOf()))
        coach2.recommend("쌈밥")
        coach2.recommend("김치찌개")
        coach2.recommend("미소시루")
        coach2.recommend("짜장면")
        coach2.recommend("팟타이")

        val coaches = Coaches(listOf(coach, coach2))

        Assertions.assertThat(coaches).hasToString(expected)
    }
}