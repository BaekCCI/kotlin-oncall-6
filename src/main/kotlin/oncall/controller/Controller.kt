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
}