package ogorkiewicz.jakub.budgetapi.repository

import ogorkiewicz.jakub.budgetapi.business.BudgetRepository
import ogorkiewicz.jakub.budgetapi.model.Budget
import org.springframework.stereotype.Repository

@Repository
class BudgetRepositoryImpl(val jpaBudgetRepository: JPABudgetRepository): BudgetRepository {

    override fun save(entity: Budget): Budget = jpaBudgetRepository.save(entity);

    override fun findBySlug(slug: String): Budget? = jpaBudgetRepository.findBySlug(slug)
}