package oncall.constant

enum class ErrorMessage(private val message: String) {
    INVALID_FORM("유효하지 않은 입력 값입니다. 다시 입력해 주세요."),
    MONTH_OUT_OF_RANGE("월은 1~12 사이여야 합니다."),
    DAY_OUT_OF_RANGE("요일은 일~토 사이여야 합니다."),
    WORKER_OUT_OF_RANGE("근무자 수는 5~35명 사이여야 합니다."),
    DUPLICATE_WORKER("중복된 닉네임이 존재합니다."),
    WORKER_NAME_LENGTH("닉네임은 최대 5자입니다."),
    SAME_WORKER("동일한 근무자를 입력해주세요.");

    fun format(): String {
        return "[ERROR] $message"
    }
}