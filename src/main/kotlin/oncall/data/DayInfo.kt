package oncall.data

data class DayInfo(
    val month: Int,
    val date: Int,
    val dayOfWeek: String,
    var isHoliday: Boolean = false
) {
    fun isWeek(): Boolean {
        return DayOfWeek.isWeek(dayOfWeek)
    }

    fun checkIsHoliday(): Boolean {
        return isHoliday
    }

}