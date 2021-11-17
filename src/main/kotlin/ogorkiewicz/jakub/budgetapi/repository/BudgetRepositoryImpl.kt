package ogorkiewicz.jakub.budgetapi.repository

import ogorkiewicz.jakub.budgetapi.model.Budget
import ogorkiewicz.jakub.budgetapi.business.BudgetRepository
import org.springframework.stereotype.Repository

@Repository
class BudgetRepositoryImpl(val jpaBudgetRepository: JPABudgetRepository): BudgetRepository {
    override fun save(entity: Budget): Budget = jpaBudgetRepository.save(entity);
}