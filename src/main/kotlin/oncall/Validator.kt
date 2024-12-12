package oncall

import oncall.data.DayOfWeek

const val MONTH_AND_DAY_REGEX = "^\\d+,[ㄱ-ㅎ가-힣]+$"
const val WORKER_INPUT_FROM_REGEX = "^[ㄱ-ㅎ가-힣a-zA-Z]+(,[ㄱ-ㅎ가-힣a-zA-Z]+)*$"
const val MAX_NUMBER_OF_WORKER = 35
const val MIN_NUMBER_OF_WORKER = 5
const val MAX_NAME_LENGTH = 5

enum class ErrorMessage(private val message: String) {
    INVALID_FORM("유효하지 않은 입력 값입니다. 다시 입력해 주세요."),
    MONTH_OUT_OF_RANGE("월은 1~12 사이여야 합니다."),
    DAY_OUT_OF_RANGE("요일은 일~토 사이여야 합니다."),
    WORKER_OUT_OF_RANGE("근무자 수는 5~35명 사이여야 합니다."),
    DUPLICATE_WORKER("중복된 닉네임이 존재합니다."),
    WORKER_NAME_LENGTH("닉네임은 최대 5자입니다."),
    SAME_WORKER("동일한 근무자를 입력해주세요.");

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

    fun validateInputWorker(input: String) {
        val formatInput = input.replace(" ", "")
        require(formatInput.matches(WORKER_INPUT_FROM_REGEX.toRegex()))
        val workers = formatInput.split(",")
        require(workers.size in MIN_NUMBER_OF_WORKER..MAX_NUMBER_OF_WORKER) { ErrorMessage.WORKER_OUT_OF_RANGE.format() }
        require(workers.distinct().size == workers.size) { ErrorMessage.DUPLICATE_WORKER.format() }
        workers.forEach {
            require(it.length <= MAX_NAME_LENGTH) { ErrorMessage.WORKER_NAME_LENGTH.format() }
        }
    }

    fun isSameWorker(weekWorker: List<String>, weekendWorker: List<String>) {
        require(weekWorker.intersect(weekendWorker).size == weekWorker.size) { ErrorMessage.SAME_WORKER.format() }
    }
}