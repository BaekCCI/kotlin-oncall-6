package oncall.model

import java.util.*

class AssignManagement(
    val calendar: List<DayInfo>,
    val weekWorker: Deque<String>,
    val weekendWorker: Deque<String>
) {
    val assignedWorkers: Deque<Worker> = LinkedList()

    init {
        assignWorker()
    }

    fun assignWorker() {
        calendar.forEach {
            if (it.isWeek()) {
                assignWeekWorker(it)
            } else if (!it.isWeek() || it.isHoliday) {
                assignWeekendWorker(it)
            }
        }
    }

    fun assignWeekWorker(dayInfo: DayInfo) {
        var temp: String? = null
        if (assignedWorkers.last.name == weekWorker.first()) {
            temp = weekWorker.first
            weekWorker.remove()
        }
        addWorker(weekWorker, dayInfo)
        weekWorker.remove()
        if (temp != null) {
            weekWorker.addFirst(temp)
        }
    }

    fun assignWeekendWorker(dayInfo: DayInfo) {
        var temp: String? = null
        if (assignedWorkers.last.name == weekendWorker.first()) {
            temp = weekendWorker.first
            weekendWorker.remove()
        }
        addWorker(weekendWorker, dayInfo)
        weekendWorker.remove()
        if (temp != null) {
            weekendWorker.addFirst(temp)
        }
    }

    fun addWorker(worker: Deque<String>, dayInfo: DayInfo) {
        assignedWorkers.addLast(
            Worker(
                name = worker.first,
                workDay = dayInfo
            )
        )
    }
    fun getSchedule():Deque<Worker>{
        return assignedWorkers
    }
}