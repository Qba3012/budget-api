package ogorkiewicz.jakub.budgetapi.dto

import ogorkiewicz.jakub.budgetapi.business.validation.UniqueSlug
import javax.validation.Valid
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

class BudgetDto(
    val id: Long?,
    @field:NotBlank @field:UniqueSlug val slug: String,
    @field:Min(value = 1) @field:Max(value = 12) val month: Int,
    @field:Min(value = 1900) @field:Max(value = 3000) val year: Int,
    @field:Valid val accounts: List<AccountDto>,
    @field:Valid val expenses: List<ExpenseDto>,
    @field:Valid val incomes: List<IncomeDto>,
)