package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.domain.Coach
import menu.domain.Coaches

class InputView {
    fun inputCoaches(): Coaches {
        val coachNames = Console.readLine().split(',')
        var coaches = mutableListOf<Coach>()
        for (c in coachNames) coaches.add(Coach(c))

        return Coaches(coaches)
    }
}