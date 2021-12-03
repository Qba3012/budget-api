package ogorkiewicz.jakub.budgetapi.business

interface ExpenseRepository {
    fun checkIfExistById(id: String): Boolean
}