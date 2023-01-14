package menu

import menu.domain.Categories
import menu.domain.Category
import menu.logic.CategoryRecommend
import menu.logic.recommendMenu
import menu.view.inputCoaches
import menu.view.outputResult
import menu.view.outputStart

fun main() {
    val coaches = inputCoaches()
    val categoryRecommend = CategoryRecommend(2)
    val categories = mutableListOf<Category>()
    (1..5).forEach {
        val category = categoryRecommend.getRecommendedCategory(null)
        recommendMenu(category, coaches)
        categories.add(category)
    }
    outputStart()
    outputResult(Categories(categories), coaches)
}
