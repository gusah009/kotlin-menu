package menu.logic

import camp.nextstep.edu.missionutils.Randoms
import menu.domain.Category
import java.util.*

class CategoryRecommend(val maxDuplicated: Int) {

    private val counters = EnumMap(Category.values().associateWith { maxDuplicated })

    fun getRecommendedCategory(replaceCategory: Category?): Category {
        replaceCategory?.let {
            counters[replaceCategory] = counters[replaceCategory]!! + 1
        }

        checkRecommendable()

        val allCategories = Category.values()
        var randomCategory: Category
        do {
            randomCategory = allCategories[Randoms.pickNumberInRange(1, allCategories.size) - 1]
            val remainedAbleCategoryCount = counters[randomCategory]!!
        } while (remainedAbleCategoryCount == 0)
        counters[randomCategory] = counters[randomCategory]!! - 1
        return randomCategory
    }

    private fun checkRecommendable() {
        if (counters.all { it.value == 0 }) {
            throw IllegalArgumentException("메뉴 추천이 불가능 합니다.")
        }
    }
}
