package ogorkiewicz.jakub.budgetapi.dummies

import ogorkiewicz.jakub.budgetapi.dto.AccountDto
import ogorkiewicz.jakub.budgetapi.dto.BudgetDto
import ogorkiewicz.jakub.budgetapi.dto.ExpenseDto
import ogorkiewicz.jakub.budgetapi.dto.IncomeDto
import ogorkiewicz.jakub.budgetapi.model.*
import java.math.BigDecimal
import java.time.LocalDateTime

class DummyData {
    companion object {
        // Values
        val TEST_DATE = LocalDateTime.now()
        val TEST_VALUE = BigDecimal(15000)

        // Account
        val ACCOUNT_ID ="test-account"
        val ACCOUNT_TITLE = "Test account"
        val ACCOUNT = Account(ACCOUNT_ID, ACCOUNT_TITLE, TEST_VALUE)
        val ACCOUNT_DTO = AccountDto(ACCOUNT_ID, ACCOUNT_TITLE, TEST_VALUE)

        // Income
        val INCOME_ID ="test-income"
        val INCOME_TITLE = "Test income"
        val INCOME = Income(INCOME_ID, INCOME_TITLE, TEST_VALUE, TEST_DATE)
        val INCOME_DTO = IncomeDto(INCOME_ID, INCOME_TITLE, TEST_VALUE, TEST_DATE)

        // Expense Type
        val EXPENSE_TYPE_ID = 1L
        val EXPENSE_TYPE_NAME = "Test type"
        val EXPENSE_TYPE = ExpenseType(EXPENSE_TYPE_ID, EXPENSE_TYPE_NAME)

        // Expense Category
        val EXPENSE_CATEGORY_ID = 1L
        val EXPENSE_CATEGORY_NAME = "Test category"
        val EXPENSE_CATEGORY = ExpenseCategory(EXPENSE_CATEGORY_ID, EXPENSE_CATEGORY_NAME)

        // Expense
        val EXPENSE_ID ="test-expense"
        val EXPENSE_TITLE = "Test expense"
        val EXPENSE = Expense(EXPENSE_ID, EXPENSE_TITLE, TEST_VALUE, TEST_DATE, EXPENSE_TYPE, EXPENSE_CATEGORY)
        val EXPENSE_DTO = ExpenseDto(EXPENSE_ID, EXPENSE_TITLE, TEST_VALUE, TEST_DATE, EXPENSE_TYPE_NAME,
            EXPENSE_CATEGORY_NAME)

        // Budget
        val BUDGET_ID = 1L
        val BUDGET_SLUG= "jan-2020"
        val BUDGET_MONTH = 1
        val BUDGET_YEAR = 2020
        val BUDGET = Budget(BUDGET_ID, BUDGET_SLUG, BUDGET_MONTH, BUDGET_YEAR, listOf(ACCOUNT), listOf(INCOME),
            listOf(EXPENSE))
        val BUDGET_DTO = BudgetDto(BUDGET_ID, BUDGET_SLUG, BUDGET_MONTH, BUDGET_YEAR, listOf(ACCOUNT_DTO), listOf
            (EXPENSE_DTO),listOf(INCOME_DTO))
    }
}
