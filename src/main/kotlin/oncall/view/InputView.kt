package oncall.view

import camp.nextstep.edu.missionutils.Console
import oncall.constant.InputMessage


class InputView {

    fun getMonthAndDayOfWeek(): String {
        print(InputMessage.MONTH_AND_DAY.format())
        return Console.readLine()
    }

    fun getWeekWorker(): String {
        print(InputMessage.WEEK_WORKER_PROMPT.format())
        return Console.readLine()
    }

    fun getWeekendWorker(): String {
        print(InputMessage.WEEKEND_WORKER_PROMPT.format())
        return Console.readLine()
    }
}