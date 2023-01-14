package menu.domain

import camp.nextstep.edu.missionutils.Randoms

data class Coaches(
    private val coaches: List<Coach>
) {

    companion object {
        const val MIN_COACHES_COUNT = 2
        const val MAX_COACHES_COUNT = 5
    }

    init {
        val isCoachesOutOfCount = MIN_COACHES_COUNT > coaches.size || MAX_COACHES_COUNT < coaches.size
        if (isCoachesOutOfCount) {
            throw IllegalArgumentException("코치는 ${MIN_COACHES_COUNT}명 이상 ${MAX_COACHES_COUNT}명 이하여야 합니다. 입력된 코치 명 수: ${coaches.size}")
        }
    }

    fun containsAll(other: Coaches): Boolean {
        return this.coaches.containsAll(other.coaches)
    }

    fun recommend(menus: List<String>) {
        for (coach in coaches) {
            var recommendedMenu: String
            do {
                val shuffleMenus = Randoms.shuffle(menus)
                recommendedMenu = shuffleMenus[0]
            } while (coach.isNotRecommendable(recommendedMenu))
            coach.recommend(recommendedMenu)
        }
    }

    override fun toString(): String {
        return coaches.map { it.toString() }.joinToString(separator = "\n")
    }
}