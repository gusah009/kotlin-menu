package menu.domain

class Categories(val categories: List<Category>) {

    // [ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]
    override fun toString(): String {
        var printList = mutableListOf("카테고리") + categories.map { it.koreaName }.toMutableList()
        return printList.joinToString(" | ", "[ ", " ]")
    }
}