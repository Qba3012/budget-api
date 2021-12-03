package ogorkiewicz.jakub.budgetapi.business

interface IncomeRepository {
    fun checkIfExistsById(id: String): Boolean
}