package ogorkiewicz.jakub.budgetapi.repository

import ogorkiewicz.jakub.budgetapi.model.ExpenseCategory
import ogorkiewicz.jakub.budgetapi.business.ExpenseCategoryRepository
import ogorkiewicz.jakub.budgetapi.repository.jpa.JPAExpenseCategoryRepository
import org.springframework.stereotype.Repository

@Repository
class ExpenseCategoryRepositoryImpl(val jpaExpenseCategoryRepository: JPAExpenseCategoryRepository): ExpenseCategoryRepository {
    override fun getByName(name: String): ExpenseCategory? = jpaExpenseCategoryRepository.findByName(name);
}