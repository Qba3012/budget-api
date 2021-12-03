package ogorkiewicz.jakub.budgetapi.dto

import ogorkiewicz.jakub.budgetapi.business.ExpenseCategoryRepository
import ogorkiewicz.jakub.budgetapi.business.ExpenseTypeRepository
import ogorkiewicz.jakub.budgetapi.model.*
import org.springframework.stereotype.Service

@Service
class ModelMapper(
    val expenseCategoryRepository: ExpenseCategoryRepository,
    val expenseTypeRepository: ExpenseTypeRepository
) {

    fun toDto(budget: Budget): BudgetDto {
        val accountDtos = budget.accounts.map { account -> toDto(account) }
        val incomeDtos = budget.incomes.map { income -> toDto(income) }
        val expenseDtos = budget.expenses.map { expense -> toDto(expense) }
        return BudgetDto(budget.id, budget.slug, budget.month, budget.year, accountDtos, expenseDtos, incomeDtos)
    }

    fun toEntity(budgetDto: BudgetDto): Budget {
        val accounts = budgetDto.accounts.map { accountDto -> toEntity(accountDto) }
        val incomes = budgetDto.incomes.map { incomeDto -> toEntity(incomeDto) }
        val expenses = budgetDto.expenses.map { expenseDto -> toEntity(expenseDto) }
        return Budget(null, budgetDto.slug, budgetDto.month, budgetDto.year, accounts, incomes, expenses)
    }

    private fun toEntity(expenseDto: ExpenseDto): Expense {
        val category = expenseCategoryRepository.getByName(expenseDto.expenseCategory);
        val type = expenseTypeRepository.getByName(expenseDto.expenseType);
        val expenseCategory = category ?: ExpenseCategory(null, expenseDto.expenseCategory);
        val expenseType = type ?: ExpenseType(null, expenseDto.expenseType);
        return Expense(
            expenseDto.id,
            expenseDto.title,
            expenseDto.amount,
            expenseDto.date,
            expenseType,
            expenseCategory
        )
    }

    private fun toEntity(incomeDto: IncomeDto): Income =
        Income(incomeDto.id, incomeDto.title, incomeDto.amount, incomeDto.date)

    private fun toEntity(accountDto: AccountDto): Account = Account(accountDto.id, accountDto.title, accountDto.amount)

    private fun toDto(expense: Expense) = ExpenseDto(
        expense.id, expense.title, expense.amount, expense.date, expense.expenseType.name, expense
            .expenseCategory.name
    )

    private fun toDto(account: Account): AccountDto = AccountDto(account.id, account.title, account.amount)

    private fun toDto(income: Income): IncomeDto = IncomeDto(income.id, income.title, income.amount, income.date)


}