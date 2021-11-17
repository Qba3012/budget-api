package ogorkiewicz.jakub.budgetapi.dto

import ogorkiewicz.jakub.budgetapi.model.Income
import java.math.BigDecimal
import java.time.LocalDateTime

class IncomeDto(
    val id: String,
    val title: String,
    val amount: BigDecimal,
    val date: LocalDateTime,
) {
    constructor(item: Income) : this(item.id, item.title, item.amount, item.date)
}