package menu.logic

import menu.domain.Category
import menu.domain.Coaches

fun recommendMenu(category: Category, coaches: Coaches) {
    val menus = category.foods
    coaches.recommend(menus)
}



