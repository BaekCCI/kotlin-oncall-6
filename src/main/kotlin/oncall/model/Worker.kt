package oncall.model

import oncall.data.DayInfo

data class Worker(
    val name : String,
    val workDay : DayInfo
)
