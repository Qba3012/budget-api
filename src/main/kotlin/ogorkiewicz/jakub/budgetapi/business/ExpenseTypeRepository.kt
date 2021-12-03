package ogorkiewicz.jakub.budgetapi.business

import ogorkiewicz.jakub.budgetapi.model.ExpenseType

interface ExpenseTypeRepository {
    fun getByName(name: String): ExpenseType?
}