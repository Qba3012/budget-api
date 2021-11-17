package ogorkiewicz.jakub.budgetapi.dto

import ogorkiewicz.jakub.budgetapi.model.Budget

class BudgetDto(
    val id: Long?,
    val slug: String,
    val month: Int,
    val year: Int,
    val accounts: List<AccountDto>,
    val expenses: List<ExpenseDto>,
    val incomes: List<IncomeDto>,
) {
    fun toEntity(): Budget = Budget(this)

    constructor(budget: Budget) : this(
        budget.id,
        budget.slug,
        budget.month,
        budget.year,
        budget.accounts.map { account -> AccountDto(account) },
        budget.expenses.map { item -> ExpenseDto(item) },
        budget.incomes.map { item -> IncomeDto(item) },
    )
}