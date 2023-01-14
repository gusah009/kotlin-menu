package menu.domain

data class Coach(
    val name: CoachName,
    val foodInedible: FoodInedible
) {

    private val recommendedMenus = mutableListOf<String>()

    fun recommend(recommendedMenu: String) {
        recommendedMenus.add(recommendedMenu)
    }

    fun isNotRecommendable(recommendedMenu: String): Boolean {
        if (foodInedible.contains(recommendedMenu)) return true
        if (recommendedMenus.contains(recommendedMenu)) return true
        return false
    }
}
