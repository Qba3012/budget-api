package ogorkiewicz.jakub.budgetapi.business

interface AccountRepository {
    fun checkIfExistById(id: String): Boolean
}