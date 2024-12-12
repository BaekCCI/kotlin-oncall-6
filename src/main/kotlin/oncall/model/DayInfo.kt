package oncall.model

import oncall.data.DayOfWeek

data class DayInfo(
    val month: Int,
    val date: Int,
    val dayOfWeek: String,
    var isHoliday: Boolean = false
) {
    fun isWeek(): Boolean {
        return DayOfWeek.entries.find { it.dayOfWeek == dayOfWeek }?.isWeek ?: false
    }

    fun checkIsHoliday(): Boolean {
        return isHoliday
    }

}