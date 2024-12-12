package oncall.constant

enum class InputMessage(val message: String) {
    MONTH_AND_DAY("비상 근무를 배정할 월과 시작 요일을 입력하세요"),
    WEEK_WORKER_PROMPT("평일 비상 근무 순번대로 사원 닉네임을 입력하세요"),
    WEEKEND_WORKER_PROMPT("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요");

    fun format(): String {
        return "$message> "
    }
}