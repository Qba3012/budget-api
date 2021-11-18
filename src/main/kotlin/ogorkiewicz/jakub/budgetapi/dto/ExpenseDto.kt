package ogorkiewicz.jakub.budgetapi.dto

import java.math.BigDecimal
import java.time.LocalDateTime

class ExpenseDto(
    val id: String,
    val title: String,
    val amount: BigDecimal,
    val date: LocalDateTime,
    val expenseType: String,
    val expenseCategory: String,
)