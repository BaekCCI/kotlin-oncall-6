package oncall.controller

import oncall.Validator
import oncall.model.CalendarManagement
import oncall.view.InputView

class Controller {
    val inputView = InputView()
    val validator = Validator()
    fun start() {
        val (month, day) = getMonthAndDay()
        val calendarManagement = CalendarManagement(month, day)
        val (weekWorker,weekendWorker) = getWorker()

    }

    fun getMonthAndDay(): Pair<Int, String> {
        while (true) {
            try {
                val input = inputView.getMonthAndDayOfWeek()
                validator.validateInputMonthAndDay(input)
                val formatInput = input.split(",").map { it.trim() }
                return Pair(formatInput[0].toInt(), formatInput[1])
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getWorker(): Pair<List<String>, List<String>> {
        while (true) {
            try {
                val weekWorker = getWeekWorker()
                val weekendWorker = getWeekendWorker()
                validator.isSameWorker(weekWorker, weekendWorker)
                return Pair(weekWorker, weekendWorker)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getWeekWorker(): List<String> {
        val input = inputView.getWeekWorker()
        validator.validateInputWorker(input)
        return input.split(",").map { it.replace(" ", "") }
    }

    fun getWeekendWorker(): List<String> {
        val input = inputView.getWeekendWorker()
        validator.validateInputWorker(input)
        return input.split(",").map { it.replace(" ", "") }
    }
}