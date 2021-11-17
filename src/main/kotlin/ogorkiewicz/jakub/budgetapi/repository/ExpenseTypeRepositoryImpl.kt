package ogorkiewicz.jakub.budgetapi.repository

import ogorkiewicz.jakub.budgetapi.model.ExpenseType
import ogorkiewicz.jakub.budgetapi.business.ExpenseTypeRepository
import org.springframework.stereotype.Repository

@Repository
class ExpenseTypeRepositoryImpl(val jpaExpenseTypeRepository: JPAExpenseTypeRepository) :
    ExpenseTypeRepository {
    override fun getByName(name: String): ExpenseType? = jpaExpenseTypeRepository.findByName(name)
}