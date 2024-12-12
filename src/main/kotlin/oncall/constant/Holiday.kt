package oncall.constant

enum class Holiday(val month: Int, val date: Int) {
    NEW_YEAR(1, 1),
    MARCH_1(3, 1),
    MAY_5(5, 5),
    JUNE_6(6, 6),
    AUGUST_15(8, 15),
    OCTOBER_3(10, 3),
    KOREAN_DAY(10, 9),
    CHRISTMAS(12, 25);

    companion object {
        fun checkIsHoliday(month: Int, date: Int): Boolean {
            return entries.any { it.month == month && it.date == date }
        }
    }
}