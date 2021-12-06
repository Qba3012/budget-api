package ogorkiewicz.jakub.budgetapi.dto

class HistoryDto(
    val year: Int,
    val months: MutableList<MonthDto> = mutableListOf(),
)