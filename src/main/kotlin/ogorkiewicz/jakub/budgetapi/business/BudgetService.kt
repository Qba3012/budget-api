package ogorkiewicz.jakub.budgetapi.business

import ogorkiewicz.jakub.budgetapi.dto.BudgetDto

interface BudgetService {
    fun save(budgetDto: BudgetDto): BudgetDto
    fun findBySlug(slug: String): BudgetDto?
}
