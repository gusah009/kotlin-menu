package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.domain.Coach
import menu.domain.CoachName
import menu.domain.Coaches
import menu.domain.FoodInedible

class InputView {
    fun inputCoaches(): Coaches {
        var coaches = mutableListOf<Coach>()
        val coachNames = inputNames()
        for (coachName in coachNames) coaches.add(Coach(coachName, inputFoods(coachName)))
        return Coaches(coaches)
    }

    private fun inputNames(): List<CoachName> {
        val names = Console.readLine().split(',')
        var coachNames = mutableListOf<CoachName>()
        for (name in names) coachNames.add(CoachName(name))
        return coachNames
    }

    private fun inputFoods(coachName: CoachName): FoodInedible {
        println("${coachName.name}(이)가 못 먹는 메뉴를 입력해 주세요.")
        val foods = Console.readLine().split(',')
        return FoodInedible(foods)
    }
}