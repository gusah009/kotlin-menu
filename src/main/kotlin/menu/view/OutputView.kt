package menu.view

import menu.domain.Categories
import menu.domain.Coaches

class OutputView {
    fun outputStart() {
        println("점심 메뉴 추천을 시작합니다.")
    }

    fun outputResult(categories: Categories, coaches: Coaches) {
        println("메뉴 추천 결과입니다.")
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")
        println(categories)
        println(coaches)
        println("추천을 완료했습니다.")
    }
}