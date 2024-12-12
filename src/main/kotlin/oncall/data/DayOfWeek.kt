package oncall.data

enum class DayOfWeek(val dayOfWeek: String, val isWeek: Boolean, val index: Int) {
    SUN("일", true, 0),
    MON("월", false, 1),
    TUE("화", false, 2),
    WED("수", false, 3),
    THUR("목", false, 4),
    FRI("금", false, 5),
    SAT("토", true, 6);

    companion object {
        fun getIndex(dayOfWeek: String): Int {
            return entries.find { it.dayOfWeek == dayOfWeek }?.index ?: throw IllegalArgumentException()
        }

        fun getDayOfWeek(index: Int): String {
            return entries.find { it.index == index }?.dayOfWeek ?: throw IllegalArgumentException()
        }

        fun isExistInDayOfWeek(input: String): Boolean {
            return entries.any { it.dayOfWeek == input }
        }
    }
}
