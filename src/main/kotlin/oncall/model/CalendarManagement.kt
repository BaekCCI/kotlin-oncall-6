package oncall.model

import oncall.data.DayOfWeek
import oncall.data.Holiday
import oncall.data.MaxDateOfMonth

data class CalendarManagement(val month: Int, val dayOfWeek: String) {
    val calendar: MutableList<DayInfo> = mutableListOf()

    init {
        initCalendar()
    }

    fun initCalendar() {
        val maxDateOfMonth = MaxDateOfMonth.getMaxDateOfMonth(month)
        var index = DayOfWeek.getIndex(dayOfWeek)
        for (i in 1..maxDateOfMonth) {
            calendar.add(
                DayInfo(
                    month = month,
                    date = i,
                    dayOfWeek = DayOfWeek.getDayOfWeek(index % 7),
                    isHoliday = Holiday.checkIsHoliday(month, i)
                )
            )
            index++
        }
    }
}