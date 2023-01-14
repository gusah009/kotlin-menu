package menu.domain

data class Coach(
    val name: String
) {
    companion object {
        const val MIN_NAME_LENGTH = 2
        const val MAX_NAME_LENGTH = 4
    }

    init {
        val isNameOutOfLength = MIN_NAME_LENGTH > name.length || name.length > MAX_NAME_LENGTH
        if (isNameOutOfLength) {
            throw IllegalArgumentException("코치의 이름의 길이는 ${MIN_NAME_LENGTH} 이상 ${MAX_NAME_LENGTH} 이하여야 합니다. 입력한 코치의 이름: ${name}")
        }
    }
}