package oncall

import MAX_NAME_LENGTH
import MAX_NUMBER_OF_WORKER
import MIN_NUMBER_OF_WORKER
import MONTH_AND_DAY_REGEX
import WORKER_INPUT_FROM_REGEX
import oncall.constant.DayOfWeek
import oncall.constant.ErrorMessage
import java.util.*

class Validator {
    fun validateInputMonthAndDay(input: String) {
        val formatInput = input.replace(" ", "")
        require(formatInput.matches(MONTH_AND_DAY_REGEX.toRegex())) { ErrorMessage.INVALID_FORM.format() }
        val monthAndDay = formatInput.split(",")
        require(monthAndDay[0].toInt() in 1..12) { ErrorMessage.MONTH_OUT_OF_RANGE.format() }
        require(DayOfWeek.isExistInDayOfWeek(monthAndDay[1])) { ErrorMessage.DAY_OUT_OF_RANGE.format() }
    }

    fun validateInputWorker(input: String) {
        val formatInput = input.replace(" ", "")
        require(formatInput.matches(WORKER_INPUT_FROM_REGEX.toRegex())) { ErrorMessage.INVALID_FORM.format() }
        val workers = formatInput.split(",")
        require(workers.size in MIN_NUMBER_OF_WORKER..MAX_NUMBER_OF_WORKER) { ErrorMessage.WORKER_OUT_OF_RANGE.format() }
        require(workers.distinct().size == workers.size) { ErrorMessage.DUPLICATE_WORKER.format() }
        workers.forEach {
            require(it.length <= MAX_NAME_LENGTH) { ErrorMessage.WORKER_NAME_LENGTH.format() }
        }
    }

    fun isSameWorker(weekWorker: Queue<String>, weekendWorker: Queue<String>) {
        require(weekWorker.intersect(weekendWorker).size == weekWorker.size) { ErrorMessage.SAME_WORKER.format() }
    }
}