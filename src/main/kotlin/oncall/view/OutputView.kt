package oncall.view

import oncall.constant.OutputMessage
import oncall.data.DayInfo

class OutputView {
    fun displayResult(dayInfo: DayInfo, name: String) {
        val holiday = if (dayInfo.isHoliday) "(휴일)" else ""
        println(OutputMessage.WORK_SCHEDULE.format(dayInfo.month, dayInfo.date, dayInfo.dayOfWeek, holiday, name))

    }
}