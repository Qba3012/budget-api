package ogorkiewicz.jakub.budgetapi.dto

import java.math.BigDecimal
import java.time.LocalDateTime

class IncomeDto(
    val id: String,
    val title: String,
    val amount: BigDecimal,
    val date: LocalDateTime,
)