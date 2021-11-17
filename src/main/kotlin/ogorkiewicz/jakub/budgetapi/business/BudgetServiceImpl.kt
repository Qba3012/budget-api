package ogorkiewicz.jakub.budgetapi.business

import ogorkiewicz.jakub.budgetapi.dto.BudgetDto
import org.springframework.stereotype.Service

@Service
class BudgetServiceImpl(val budgetRepository: BudgetRepository): BudgetService {
    override fun save(budgetDto: BudgetDto): BudgetDto {
        val entity = budgetRepository.save(budgetDto.toEntity())
        return BudgetDto(entity)
    }
}
