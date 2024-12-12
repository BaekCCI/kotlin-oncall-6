package oncall.constant

enum class DayOfWeek(val dayOfWeek: String, val isWeek: Boolean, val index: Int) {
    SUN("일", false, 0),
    MON("월", true, 1),
    TUE("화", true, 2),
    WED("수", true, 3),
    THUR("목", true, 4),
    FRI("금", true, 5),
    SAT("토", false, 6);

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
        fun isWeek(dayOfWeek:String):Boolean{
            return entries.find { it.dayOfWeek == dayOfWeek }?.isWeek ?: false
        }
    }
}
