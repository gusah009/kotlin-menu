package menu.domain

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
}