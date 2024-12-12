package oncall.controller

import oncall.Validator
import oncall.model.AssignManagement
import oncall.model.CalendarManagement
import oncall.model.Worker
import oncall.view.InputView
import oncall.view.OutputView
import java.util.*

class Controller {
    val inputView = InputView()
    val validator = Validator()
    val outputView = OutputView()

    fun start() {
        val (month, day) = getMonthAndDay()
        val calendarManagement = CalendarManagement(month, day)
        val calendar = calendarManagement.calendar
        val (weekWorker, weekendWorker) = getWorker()
        val assignManagement = AssignManagement(calendar, weekWorker, weekendWorker)
        displayResult(assignManagement.getSchedule())
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

    fun getWorker(): Pair<Deque<String>, Deque<String>> {
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

    fun getWeekWorker(): Deque<String> {
        val input = inputView.getWeekWorker()
        validator.validateInputWorker(input)
        val weekWorker: Deque<String> = LinkedList()
        val workers = input.split(",").map { it.replace(" ", "") }
        workers.forEach {
            weekWorker.addLast(it)
        }
        return weekWorker
    }

    fun getWeekendWorker(): Deque<String> {
        val input = inputView.getWeekendWorker()
        validator.validateInputWorker(input)
        val weekendWorker: Deque<String> = LinkedList()
        val workers = input.split(",").map { it.replace(" ", "") }
        workers.forEach {
            weekendWorker.addLast(it)
        }
        return weekendWorker
    }

    fun displayResult(schedule: Deque<Worker>) {
        println()
        schedule.forEach {
            outputView.displayResult(it.workDay, it.name)
        }

    }
}