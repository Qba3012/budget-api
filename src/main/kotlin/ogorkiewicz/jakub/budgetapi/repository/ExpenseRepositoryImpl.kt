package ogorkiewicz.jakub.budgetapi.repository

import ogorkiewicz.jakub.budgetapi.business.ExpenseRepository
import ogorkiewicz.jakub.budgetapi.repository.jpa.JPAExpenseRepository
import org.springframework.stereotype.Repository

@Repository
class ExpenseRepositoryImpl(val jpaExpenseRepository: JPAExpenseRepository) : ExpenseRepository {
    override fun checkIfExistById(id: String) = jpaExpenseRepository.existsById(id)
}
