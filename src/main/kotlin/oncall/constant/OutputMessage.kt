package oncall.constant

enum class OutputMessage(val message: String) {
    WORK_SCHEDULE("%d월 %d일 %s%s %s");

    fun format(vararg args: Any): String {
        return message.format(*args)
    }
}