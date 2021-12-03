package ogorkiewicz.jakub.budgetapi.business

import ogorkiewicz.jakub.budgetapi.model.ExpenseCategory

interface ExpenseCategoryRepository {
    fun getByName(name: String): ExpenseCategory?
}