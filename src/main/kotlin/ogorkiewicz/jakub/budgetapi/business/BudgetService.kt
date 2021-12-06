package ogorkiewicz.jakub.budgetapi.business

import ogorkiewicz.jakub.budgetapi.dto.BudgetDto
import ogorkiewicz.jakub.budgetapi.dto.HistoryDto
import javax.validation.Valid

interface BudgetService {
    fun save(@Valid budgetDto: BudgetDto): BudgetDto
    fun findBySlug(slug: String): BudgetDto?
    fun findLatest(): BudgetDto?
    fun getHistory(): List<HistoryDto>?
}
