package ogorkiewicz.jakub.budgetapi.business

import ogorkiewicz.jakub.budgetapi.model.Budget

interface BudgetRepository {
    fun save(entity: Budget): Budget
    fun findBySlug(slug: String): Budget?
}
