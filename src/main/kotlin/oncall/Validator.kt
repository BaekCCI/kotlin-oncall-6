package oncall

import oncall.data.DayOfWeek

const val MONTH_AND_DAY_REGEX = "^\\d+,[ㄱ-ㅎ가-힣]+$"

enum class ErrorMessage(private val message: String) {
    INVALID_FORM("유효하지 않은 입력 값입니다. 다시 입력해 주세요."),
    MONTH_OUT_OF_RANGE("월은 1~12 사이여야 합니다."),
    DAY_OUT_OF_RANGE("요일은 일~토 사이여야 합니다.");

    fun format(): String {
        return "[ERROR] $message"
    }
}

class Validator {
    fun validateInputMonthAndDay(input: String) {
        require(input.matches(MONTH_AND_DAY_REGEX.toRegex())) { ErrorMessage.INVALID_FORM.format() }
        val formatInput = input.split(",").map { it.trim() }
        require(formatInput[0].toInt() in 1..12) { ErrorMessage.MONTH_OUT_OF_RANGE.format() }
        require(DayOfWeek.isExistInDayOfWeek(formatInput[1])) { ErrorMessage.DAY_OUT_OF_RANGE.format() }
    }
}