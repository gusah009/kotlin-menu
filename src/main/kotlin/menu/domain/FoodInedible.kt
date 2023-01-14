package menu.domain

data class FoodInedible(val foods: List<String>) {
    companion object {
        const val FODDS_DONT_EAT_MAX_LENGTH = 2
    }

    init {
        if (foods.size > FODDS_DONT_EAT_MAX_LENGTH) {
            throw IllegalArgumentException("코치가 못먹는 음식은 ${FODDS_DONT_EAT_MAX_LENGTH}개 이하여야 합니다. 입력한 코치가 못먹는 음식 개수: ${foods.size}")
        }
    }

    fun contains(food: String): Boolean {
        return foods.contains(food)
    }
}