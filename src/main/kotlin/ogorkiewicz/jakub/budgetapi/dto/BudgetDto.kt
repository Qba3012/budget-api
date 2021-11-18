package ogorkiewicz.jakub.budgetapi.dto

class BudgetDto(
    val id: Long?,
    val slug: String,
    val month: Int,
    val year: Int,
    val accounts: List<AccountDto>,
    val expenses: List<ExpenseDto>,
    val incomes: List<IncomeDto>,
)