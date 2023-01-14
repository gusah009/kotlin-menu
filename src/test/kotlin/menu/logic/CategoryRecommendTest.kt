package menu.logic

import menu.domain.Category
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CategoryRecommendTest {

    val maxDuplicate = 2

    @Test
    fun should_throwException_when_recommendTooMany() {
        val categoryRecommend = CategoryRecommend(maxDuplicate)

        for (i in 1..(Category.values().size * maxDuplicate)) {
            categoryRecommend.getRecommendedCategory(null)
        }
        assertThrows<IllegalArgumentException> { categoryRecommend.getRecommendedCategory(null) }
    }

    @Test
    fun should_returnEachCategoryOnlyTwo_when_countIsValid() {
        val categoryRecommend = CategoryRecommend(maxDuplicate)

        val result = mutableListOf<Category>()
        for (i in 1..(Category.values().size * maxDuplicate)) {
            result.add(categoryRecommend.getRecommendedCategory(null))
        }
        Assertions.assertThat(result.count { it == Category.Japanese }).isEqualTo(maxDuplicate)
        Assertions.assertThat(result.count { it == Category.Korean }).isEqualTo(maxDuplicate)
        Assertions.assertThat(result.count { it == Category.Chinese }).isEqualTo(maxDuplicate)
        Assertions.assertThat(result.count { it == Category.Asian }).isEqualTo(maxDuplicate)
        Assertions.assertThat(result.count { it == Category.Western }).isEqualTo(maxDuplicate)
    }

    @Test
    fun should_returnEachCategoryOnlyTwo_when_replaceCategory() {
        val categoryRecommend = CategoryRecommend(maxDuplicate)

        val result = mutableListOf<Category>()
        for (i in 1..(Category.values().size * maxDuplicate)) {
            result.add(categoryRecommend.getRecommendedCategory(null))
        }
        val lastCategory = result.removeLast()
        result.add(categoryRecommend.getRecommendedCategory(lastCategory))
        Assertions.assertThat(result.count { it == Category.Japanese }).isEqualTo(maxDuplicate)
        Assertions.assertThat(result.count { it == Category.Korean }).isEqualTo(maxDuplicate)
        Assertions.assertThat(result.count { it == Category.Chinese }).isEqualTo(maxDuplicate)
        Assertions.assertThat(result.count { it == Category.Asian }).isEqualTo(maxDuplicate)
        Assertions.assertThat(result.count { it == Category.Western }).isEqualTo(maxDuplicate)
    }
}