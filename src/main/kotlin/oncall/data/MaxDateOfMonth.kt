package oncall.data

enum class MaxDateOfMonth(val maxDate: Int, val month: List<Int>) {
    DAY_31(31, listOf(1, 3, 5, 7, 8, 10, 12)),
    DAY_30(30, listOf(4, 6, 9, 11)),
    DAY_28(28, listOf(2));

    companion object {
        fun getMaxDateOfMonth(month: Int): Int {
            return entries.find { it.month.contains(month) }?.maxDate ?: throw IllegalArgumentException()
        }
    }
}