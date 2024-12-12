package oncall.view

import oncall.data.DayInfo

enum class OutputMessage(val message: String) {
    WORK_SCHEDULE("%d월 %d일 %s%s %s");

    fun format(vararg args: Any): String {
        return message.format(*args)
    }
}

class OutputView {
    fun displayResult(dayInfo: DayInfo, name: String) {
        val holiday = if (dayInfo.isHoliday) "(휴일)" else ""
        println(OutputMessage.WORK_SCHEDULE.format(dayInfo.month, dayInfo.date, dayInfo.dayOfWeek, holiday, name))

    }
}