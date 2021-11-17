package ogorkiewicz.jakub.budgetapi.dto

import ogorkiewicz.jakub.budgetapi.model.Expense
import java.math.BigDecimal
import java.time.LocalDateTime

class ExpenseDto(
    val id: String,
    val title: String,
    val amount: BigDecimal,
    val date: LocalDateTime,
    val expenseType: String,
    val expenseCategory: String,
) {
    constructor(item: Expense) : this(item.id, item.title, item.amount, item.date, item.expenseType.name, item
        .expenseCategory.name)
}